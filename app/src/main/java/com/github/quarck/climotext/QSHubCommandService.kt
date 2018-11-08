package com.github.quarck.climotext

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService
import android.util.Log
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Button

@SuppressLint("Registered")
open class QSHubCommandService() : TileService() {

//    private var isTileActive: Boolean = false

    fun showDialog(layoutInflater: LayoutInflater): AlertDialog? {

        val dialogView = layoutInflater.inflate(R.layout.dialog_popup, null)

        val builder = AlertDialog.Builder(this)
        builder.setView(dialogView)

        builder.setNegativeButton(android.R.string.cancel) {
                dialog, which -> dialog.dismiss()
        }

        val dialog = builder.create()

        dialogView.findViewById<Button>(R.id.buttonLiving05).setOnClickListener {
            HubCommands.boost(HubCommands.DESTINATION_LIVING, "0.5")
            dialog.dismiss()
        }
        dialogView.findViewById<Button>(R.id.buttonLiving10).setOnClickListener {
            HubCommands.boost(HubCommands.DESTINATION_LIVING, "1")
            dialog.dismiss()
        }
        dialogView.findViewById<Button>(R.id.buttonLiving20).setOnClickListener {
            HubCommands.boost(HubCommands.DESTINATION_LIVING, "2")
            dialog.dismiss()
        }
        dialogView.findViewById<Button>(R.id.buttonLivingC).setOnClickListener {
            HubCommands.cancelBoost(HubCommands.DESTINATION_LIVING)
            dialog.dismiss()
        }

        dialogView.findViewById<Button>(R.id.buttonBed05).setOnClickListener {
            HubCommands.boost(HubCommands.DESTINATION_BED, "0.5")
            dialog.dismiss()
        }
        dialogView.findViewById<Button>(R.id.buttonBed10).setOnClickListener {
            HubCommands.boost(HubCommands.DESTINATION_BED, "1")
            dialog.dismiss()
        }
        dialogView.findViewById<Button>(R.id.buttonBed20).setOnClickListener {
            HubCommands.boost(HubCommands.DESTINATION_BED, "2")
            dialog.dismiss()
        }
        dialogView.findViewById<Button>(R.id.buttonBedC).setOnClickListener {
            HubCommands.cancelBoost(HubCommands.DESTINATION_BED)
            dialog.dismiss()
        }

        dialogView.findViewById<Button>(R.id.buttonWater05).setOnClickListener {
            HubCommands.boost(HubCommands.DESTINATION_WATER, "0.5")
            dialog.dismiss()
        }
        dialogView.findViewById<Button>(R.id.buttonWater10).setOnClickListener {
            HubCommands.boost(HubCommands.DESTINATION_WATER, "1")
            dialog.dismiss()
        }
        dialogView.findViewById<Button>(R.id.buttonWater20).setOnClickListener {
            HubCommands.boost(HubCommands.DESTINATION_WATER, "2")
            dialog.dismiss()
        }
        dialogView.findViewById<Button>(R.id.buttonWaterC).setOnClickListener {
            HubCommands.cancelBoost(HubCommands.DESTINATION_WATER)
            dialog.dismiss()
        }

        return dialog
    }


    override fun onClick() {

        val dialog = showDialog(LayoutInflater.from(this))
        this.showDialog(dialog)
    }

    private fun updateTile() {
        val tile = super.getQsTile()
        tile.state = Tile.STATE_ACTIVE
        tile.updateTile()
    }
}
