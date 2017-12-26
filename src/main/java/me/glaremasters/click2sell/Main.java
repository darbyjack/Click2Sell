package me.glaremasters.click2sell;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by GlareMasters on 12/24/2017.
 */
public class Main extends JavaPlugin {

    private static Main instance;
    public static Main getInstance() {
        return instance;
    }

    public void onEnable() {
        instance = this;
        this.saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new Listener(), this);
    }

    public void onDisable() {

    }

}
