package com.frogman786.slender;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import com.frogman786.slender.Main;
import com.frogman786.slender.utils.Tracking;

public class Events implements Listener {
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent evt){
		Player player = evt.getPlayer();
		if(Main.trackingmap.containsKey(player.getName())){
			if(Main.trackingmap.get(player.getName())){
				Player tracked = Tracking.getNearest(player);
				player.setCompassTarget(tracked.getLocation());
			}
		}
	}
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent evt){
		if(Main.playinglist.contains(evt.getEntity().getName())){
			
		}
	}
}
