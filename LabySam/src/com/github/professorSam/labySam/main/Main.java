package com.github.professorSam.labySam.main;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.github.professorSam.labySam.functions.Banner;
import com.github.professorSam.labySam.functions.Gamemode;
import com.github.professorSam.labySam.functions.VoiceChat;
import com.github.professorSam.labySam.protocol.LabyModProtocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class Main extends JavaPlugin implements PluginMessageListener{
	private static Main plugin;
	@Override
	public void onEnable() {
		plugin = this;
		plugin.saveDefaultConfig();
		plugin.saveConfig();
		getServer().getMessenger().registerIncomingPluginChannel(this, "labymod3:main", this);
		getServer().getPluginManager().registerEvents(new Banner(), this);
		getServer().getPluginManager().registerEvents(new Gamemode(), this);
		getServer().getPluginManager().registerEvents(new VoiceChat(), this);
	}

	@Override
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
		if (!channel.equals("labymod3:main")) {
	        return;
	    }

	    DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));

	    ByteBuf buf = Unpooled.wrappedBuffer(message);
		String key = LabyModProtocol.readString(buf, Short.MAX_VALUE);
		String json = LabyModProtocol.readString(buf, Short.MAX_VALUE);

		// LabyMod user joins the server
		if(key.equals("INFO")) {
		    // Handle the json message
		}
		
	}
	public static Main getPlugin() {
		return plugin;
	}
}
