package me.abetgt.mercuryapi.specials;

import org.bukkit.plugin.java.JavaPlugin;

public class MercuryAPIData extends JavaPlugin {

    private static MercuryAPIData mercuryPlugin;

    @Override
    public void onEnable(){
        mercuryPlugin = this;
    }

    /**
     * Checks if a class exists.
     *
     * @param className
     * @return True if found; false if exception.
     */
    public static MercuryServerSoftware getServerSoftware(String className){
        if (classExists("net.glowstone.GlowServer"))
            return MercuryServerSoftware.BUKKIT_GLOWSTONE;
        if (classExists("co.aikar.timings.Timings"))
            return MercuryServerSoftware.BUKKIT_PAPER;
        if (classExists("org.spigotmc.SpigotConfig"))
            return MercuryServerSoftware.BUKKIT_SPIGOT;
        if (classExists("org.bukkit.craftbukkit.CraftServer") || classExists("org.bukkit.craftbukkit.Main"))
            return MercuryServerSoftware.BUKKIT_CRAFTBUKKIT;
        return MercuryServerSoftware.BUKKIT_UNKNOWN;
    }

    public static boolean classExists(String className){
        try {
            Class.forName(className);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static MercuryAPIData getMercuryPlugin(){
        return mercuryPlugin;
    }
}