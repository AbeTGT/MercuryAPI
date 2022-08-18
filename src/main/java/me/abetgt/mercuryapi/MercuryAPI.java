package me.abetgt.mercuryapi;

import me.abetgt.mercuryapi.events.player.PlayerInfluenceFlowerPotEvent;
import me.abetgt.mercuryapi.events.player.MercuryListener_PlayerInfluenceFlowerPotEvent;
import me.abetgt.mercuryapi.events.player.PlayerOpenMerchantInventoryEvent;
import me.abetgt.mercuryapi.events.player.MercuryListener_PlayerOpenMerchantInventoryEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class MercuryAPI extends JavaPlugin implements Listener {

    private static Plugin mercuryPlugin;

    @EventHandler
    public void onOpenMerchant(PlayerOpenMerchantInventoryEvent event){
        Bukkit.getLogger().info("It worked! Player inventory open thing lol.");
    }

    @EventHandler
    public void onFlowerPot(PlayerInfluenceFlowerPotEvent event){
        Bukkit.getLogger().info("It worked! Player flower pot thing lol.");
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        mercuryPlugin = this;
        getServer().getPluginManager().registerEvents(new MercuryListener_PlayerOpenMerchantInventoryEvent(), this);
        getServer().getPluginManager().registerEvents(new MercuryListener_PlayerInfluenceFlowerPotEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Plugin getMercuryPlugin(){
        return mercuryPlugin;
    }



}
