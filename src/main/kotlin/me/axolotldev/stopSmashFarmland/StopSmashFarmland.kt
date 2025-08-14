package me.axolotldev.stopSmashFarmland

import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.plugin.java.JavaPlugin

class StopSmashFarmland : JavaPlugin(), Listener {

    override fun onEnable() {
        logger.info("Stop Smash Farmland Enabled")

        server.pluginManager.registerEvents(this, this)
    }

    override fun onDisable() {
        logger.info("Stop Smash Farmland Disabled")
    }

    @EventHandler(priority = EventPriority.HIGH)
    fun on(event: PlayerInteractEvent) {
        if (event.action != Action.PHYSICAL) return
        if (event.clickedBlock?.type != Material.FARMLAND) return
        if (event.player.hasPermission("ssf.bypass")) return
        event.isCancelled = true
    }

}
