package com.frogman786.slender;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.frogman786.slender.commands.Cfg;
import com.frogman786.slender.commands.General;
import com.frogman786.slender.commands.Tracking;
 
public class Main extends JavaPlugin{
   
    private static Plugin plugin;
    public static List<String> playinglist = new ArrayList<String>();
    public static Map<String, String> configmap = new HashMap<String, String>();
    public static Map<String,Boolean> trackingmap = new HashMap<String, Boolean>();
    
    public void onEnable() {
        plugin = this;
        registerEvents(this, new Events());
        configini();
        commandini();
    }
   
    public void onDisable() {
       
    }
    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }
    public static Plugin getPlugin() {
        return plugin;
    }
    
    private void configini(){
    	FileConfiguration config = getConfig();
		config.options().copyDefaults(true);
		saveConfig();
		for(String str: getConfig().getKeys(true)) {
			 
			String p = getConfig().getString(str);
			 
			configmap.put(str, p);
		}
    }
    
    private void commandini(){
    	//main
    	getCommand("slender").setExecutor(new General());
        //compass
        getCommand("track").setExecutor(new Tracking());
        getCommand("untrack").setExecutor(new Tracking());
        //debugs
        getCommand("cfgdebug").setExecutor(new Cfg());
        getCommand("trackdebug").setExecutor(new Tracking());
    }
   // TODO write up
    // effects hotswapable
    // normal player stoneaxe, iron helmet, 10 steak
    // slender compass, bow(infinity), arrow, wood sword, 16 enderpearls, stained leather pants chest boots (FFFFFF)
    // lives 3
    // command tree /general <join/quit/admin>
    // admin effects <effect> [on/off]
    // admin define <1/2>
    // admin defineend <1/2> (enderman can't enter)
    // admin 
    
   
   
 
}