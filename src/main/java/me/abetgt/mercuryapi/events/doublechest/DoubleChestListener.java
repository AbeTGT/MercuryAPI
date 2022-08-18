package me.abetgt.mercuryapi.events.doublechest;

import me.abetgt.mercuryapi.MercuryAPI;
import org.bukkit.Bukkit;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.block.DoubleChest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.DoubleChestInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public final class DoubleChestListener implements Listener {
    @EventHandler
    public void getDoubleChest(BlockPlaceEvent event) {
        Bukkit.getLogger().info("Received BlockPlaceEvent");
        BlockState chestState = event.getBlock().getState();
        DoubleChest doubleChest = null;
        Bukkit.getLogger().info("Finished First Variables");
        if (chestState instanceof Chest) {
            Chest chest = (Chest) chestState;
            Inventory inventory = chest.getInventory();
            Bukkit.getLogger().info("Detected Chest");
            if (inventory instanceof DoubleChestInventory) {
                Bukkit.getLogger().info("Detected DoubleChestInventory");
                doubleChest = (DoubleChest) inventory.getHolder();
                Bukkit.getLogger().info("Received Holder");
                DoubleChestEvent chestEvent = new DoubleChestEvent(
                        event.getPlayer(),
                        event.getBlock(),
                        chestState,
                        doubleChest,
                        event.getBlockAgainst(),
                        doubleChest.getLeftSide(),
                        doubleChest.getRightSide()
                );
                Bukkit.getLogger().info("Finished Event");
                Bukkit.getServer().getPluginManager().callEvent(chestEvent);
                Bukkit.getLogger().info("Called Event, finished!");
                if (chestEvent.isCancelled()){ event.setCancelled(true); }
            }
        }
    }
}
