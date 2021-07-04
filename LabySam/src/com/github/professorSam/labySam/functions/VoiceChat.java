package com.github.professorSam.labySam.functions;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.github.professorSam.labySam.main.Main;
import com.github.professorSam.labySam.protocol.LabyModProtocol;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class VoiceChat implements Listener{
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event) {
		if(Main.getPlugin().getConfig().getBoolean("VoiceChat.Recommend") == true) {
			recommendAddons(event.getPlayer());
		}
		
	}

	public void recommendAddons(Player player) {
		JsonObject object = new JsonObject();
		JsonArray addons = new JsonArray();

		JsonObject addon = new JsonObject();
		addon.addProperty( "uuid", "55c0c094-b79e-4c1b-bfb8-1a9f947c3314" ); // Published uuid of the addon
		addon.addProperty( "required", false ); // Required for this server?
    	addons.add(addon);

    	object.add( "addons", addons );

    	// Send to LabyMod using the API
    	LabyModProtocol.sendLabyModMessage(player, "addon_recommendation", object );
}

}
