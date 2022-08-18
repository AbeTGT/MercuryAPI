package me.abetgt.mercuryapi.specials;

public enum MercuryServerSoftware {
    BUKKIT_UNKNOWN("Unknown Bukkit", false, false),
    BUKKIT_CRAFTBUKKIT("CraftBukkit", false, false),
    BUKKIT_SPIGOT("Spigot", true, true),
    BUKKIT_PAPER("Paper", true, true),
    BUKKIT_GLOWSTONE("Glowstone", true, false),
    SPONGE("Sponge", false, false);

    public String name;

    public boolean works;

    public boolean supported;

    MercuryServerSoftware(String name, boolean works, boolean supported) {
        this.name = name;
        this.works = works;
        this.supported = supported;
    }
}
