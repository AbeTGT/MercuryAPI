package me.abetgt.mercuryapi.events.player;

import me.abetgt.mercuryapi.specials.MercuryAPIData;
import me.abetgt.mercuryapi.specials.MercuryServerSoftware;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.MerchantInventory;

public final class MercuryListener_PlayerOpenMerchantInventoryEvent implements Listener {
    @EventHandler
    public void onMerchantOpen(InventoryOpenEvent event) {
        if (event.getInventory() instanceof MerchantInventory) {
            MerchantInventory merchantInventory = (MerchantInventory) event.getInventory();
            PlayerOpenMerchantInventoryEvent openMerchant = new PlayerOpenMerchantInventoryEvent(
                    (Player) event.getPlayer(),
                    event.getInventory(),
                    merchantInventory,
                    merchantInventory.getMerchant(),
                    merchantInventory.getSize()
            );
            Bukkit.getServer().getPluginManager().callEvent(openMerchant);
            if (openMerchant.isCancelled()) {
                event.setCancelled(true);
            }
        }
    }
}
