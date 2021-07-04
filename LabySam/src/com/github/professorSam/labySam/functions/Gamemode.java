package com.github.professorSam.labySam.functions;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.github.professorSam.labySam.main.Main;
import com.github.professorSam.labySam.protocol.LabyModProtocol;
import com.google.gson.JsonObject;

public class Gamemode implements Listener {
	@EventHandler
	public void onJoinEvent(PlayerJoinEvent event) {
		String mode = Main.getPlugin().getConfig().getString("Gamemode.Name");
		sendCurrentPlayingGamemode(event.getPlayer(), true, mode);
	}
	
	public void sendCurrentPlayingGamemode( Player player, boolean visible, String gamemodeName ) {
	    JsonObject object = new JsonObject();
	    object.addProperty( "show_gamemode", visible ); // Gamemode visible for everyone
	    object.addProperty( "gamemode_name", gamemodeName ); // Name of the current playing gamemode

	    // Send to LabyMod using the API
	    LabyModProtocol.sendLabyModMessage( player, "server_gamemode", object );
	}
}
