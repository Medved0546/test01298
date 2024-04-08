package zako.testplugin.listeners;

import zako.testplugin.events.PlayerBreakShulkerEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerShulkerBreak implements Listener {

    @EventHandler
    private void on(BlockBreakEvent event) {
        Block block = event.getBlock();
        if (block.getType() == Material.SHULKER_BOX) {
            final PlayerBreakShulkerEvent e = new PlayerBreakShulkerEvent(event.getPlayer(), block);
            Bukkit.getPluginManager().callEvent(e);
            if(e.isCancelled()) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    private void on(PlayerBreakShulkerEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("вы сломали шалкер");
        if (Math.random() >= 0.5) {
            event.setCancelled(true);
        }
    }
}
