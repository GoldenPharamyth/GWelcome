package ua.gpdev.gwelcome.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class JoinPlayer implements Listener {

    private final JavaPlugin plugin;

    public JoinPlayer(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Deprecated
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(null);

        String playerName;
        if (player.hasPlayedBefore()) {
            playerName = Objects.requireNonNull(plugin.getConfig().getString("join-message")).replace("%player%", player.getName());
        } else {
            playerName = Objects.requireNonNull(plugin.getConfig().getString("first-join-message")).replace("%player%", player.getName());
        }
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', playerName));
    }
}
