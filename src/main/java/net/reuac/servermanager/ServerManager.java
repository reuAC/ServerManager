package net.reuac.servermanager;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerManager extends JavaPlugin {
    static public String pluginsName = "ServerManager";
    static ServerManager main;

    @Override
    public void onEnable() {
        Bukkit.getPluginCommand("servermanager").setExecutor(new MainCommand());
        Bukkit.getPluginManager().registerEvents(new MainListener(),this);

        saveDefaultConfig();
        loadConfig();

        main = this;
    }

    @Override
    public void onDisable() {

    }

    public void loadConfig(){
        MainListener.autoVenable = getConfig().getBoolean("autoInvisible");
    }
}
