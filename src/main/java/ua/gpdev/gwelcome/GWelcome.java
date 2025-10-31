package ua.gpdev.gwelcome;

import org.bukkit.plugin.java.JavaPlugin;
import ua.gpdev.gwelcome.listeners.JoinPlayer;
import ua.gpdev.gwelcome.listeners.QuitPlayer;

public final class GWelcome extends JavaPlugin {

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(new JoinPlayer(this), this);
        getServer().getPluginManager().registerEvents(new QuitPlayer(this), this);

    }
}
