package com.github.professorSam.labySam.functions;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.github.professorSam.labySam.main.Main;
import com.github.professorSam.labySam.protocol.LabyModProtocol;
import com.google.gson.JsonObject;

public class Banner implements Listener{
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		String banner = Main.getPlugin().getConfig().getString("Banner.Link");
		sendServerBanner(event.getPlayer(), banner);
	}
	public void sendServerBanner(Player player, String imageUrl) {
	    JsonObject object = new JsonObject();
	    object.addProperty("url", imageUrl); // Url of the image
	    LabyModProtocol.sendLabyModMessage(player, "server_banner", object);
	}
}
