package ua.gpdev.gwelcome.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class QuitPlayer implements Listener {

    private final JavaPlugin plugin;

    public QuitPlayer(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Deprecated
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage(null);

        String playerName;
        playerName = Objects.requireNonNull(plugin.getConfig().getString("quit-message")).replace("%player%", player.getName());
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', playerName));
    }
}
