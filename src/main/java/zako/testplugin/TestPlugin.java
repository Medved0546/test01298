package zako.testplugin;

import zako.testplugin.listeners.PlayerJoin;
import org.bukkit.plugin.java.JavaPlugin;
import zako.testplugin.listeners.PlayerPlaceDiamondOre;
import zako.testplugin.listeners.PlayerShulkerBreak;

public final class TestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerPlaceDiamondOre(), this);
        getServer().getPluginManager().registerEvents(new PlayerShulkerBreak(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
