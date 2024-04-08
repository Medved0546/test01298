package zako.testplugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void on(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        player.sendMessage("Hello " + ChatColor.BLUE + player.getName());
    }
}
