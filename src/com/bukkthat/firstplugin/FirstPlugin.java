// The package that contains the class
package com.bukkthat.firstplugin;

// Import everything we use from the Bukkit API
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/*
 * Our class is named FirstPlugin, every word capitalized by convention
 * It extends the class JavaPlugin which allows you to use all the methods
 * contained in it.
 * It implements the interface Listener which allows the methods in this class
 * to be called when the events are triggered.
 */
public class FirstPlugin extends JavaPlugin implements Listener {

	/**
	 * This method is called when the server enables the plugin.
	 */
	public void onEnable() {
		//Get the plugin manager
		PluginManager pm = getServer().getPluginManager();
		//Register the events in this class, with the main class also being this.
		pm.registerEvents(this, this);
	}

	/**
	 * This method is called everytime a block is placed.
	 * It will then tell the player what type the block was.
	 */
	@EventHandler //Important annotation, tells Bukkit that this is a Listener method
	public void onBlockPlace(BlockPlaceEvent event) {
		//Get the player who triggered the event.
		Player player = event.getPlayer();
		//Tell the player what type of block he placed.
		player.sendMessage(ChatColor.GOLD + "You placed a " + event.getBlock().getType());
	}

	/**
	 * This method is called everytime a block is broken. It will then tell the
	 * player what type the block was.
	 */
	@EventHandler //Important annotation, tells Bukkit that this is a Listener method
	public void onBlockBreak(BlockBreakEvent event) {
		//Get the player who triggered the event.
		Player player = event.getPlayer();
		//Tell the player what type of block he broke.
		player.sendMessage(ChatColor.GOLD + "You broke a " + event.getBlock().getType());
	}

}
