package me.statuxia.forcerunner;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Forcerunner extends JavaPlugin {

    @Override
    public void onEnable() {
        ForceFeather.construct();
        Bukkit.getPluginManager().registerEvents(new Events(), this);
    }
}
