package me.abetgt.mercuryapi.events.player;

import me.abetgt.mercuryapi.MercuryAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;


public final class MercuryListener_PlayerInfluenceFlowerPotEvent implements Listener {
    Plugin mercuryPlugin = MercuryAPI.getMercuryPlugin();
    @EventHandler
    public void onInteractBlock(PlayerInteractEvent event){
        Block eventBlock = event.getClickedBlock();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK && eventBlock.getBlockData().getMaterial() == Material.FLOWER_POT){
            EquipmentSlot eventHand = event.getHand();
            ItemStack heldItem = event.getItem();
            if (!event.hasItem()){return;}
            Bukkit.getScheduler().scheduleSyncDelayedTask(mercuryPlugin, new Runnable() {
                @Override
                public void run() {
                    String setType = eventBlock.getType().name();
                    if (setType.startsWith("POTTED") || setType.startsWith("potted")) {
                        PlayerInfluenceFlowerPotEvent flowerPotEvent = new PlayerInfluenceFlowerPotEvent(
                                event.getPlayer(),
                                eventBlock,
                                eventHand,
                                heldItem,
                                eventBlock.getType()
                        );
                    }
                }
        }, 5);
    }
}}
