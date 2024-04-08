package zako.testplugin.listeners;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import zako.testplugin.events.PlayerPlaceDiamondOreEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlayerPlaceDiamondOre implements Listener {

    //При установке алмазной руды
    @EventHandler
    private void on(BlockPlaceEvent event) {
        Block block = event.getBlock();
        if (block.getType() == Material.DIAMOND_ORE) {
            final PlayerPlaceDiamondOreEvent e = new PlayerPlaceDiamondOreEvent(event.getPlayer(), block);
            Bukkit.getPluginManager().callEvent(e);
            if (e.isCancelled()) {
                event.setCancelled(true);
            }
        }
    }

    //Он с вероятностью 50% вернёт установившему её обратно в 0 слот инвентаря в размере 2 штук
    @EventHandler
    public void on(PlayerPlaceDiamondOreEvent event) {
        event.setCancelled(true);
        Player player = event.getPlayer();
        if (Math.random() >= 0.5) {
            player.getInventory().setItem(0, new ItemStack(Material.DIAMOND_ORE, 2));
        } else {
            player.sendMessage("Вам не повезло и вы не получили бонусную алмазную руду((");
        }
    }
}
