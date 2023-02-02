package com.zp4rker.serverpause;

import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Listeners implements Listener {
    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        if (Boolean.FALSE.equals(event.getPlayer().getWorld().getGameRuleValue(GameRule.DO_DAYLIGHT_CYCLE))) {
            event.getPlayer().getWorld().setGameRule(GameRule.DO_DAYLIGHT_CYCLE, true);
            Bukkit.getLogger().info("Daylight cycle has been resumed");
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        if (event.getPlayer().getServer().getOnlinePlayers().size() == 0) {
            event.getPlayer().getWorld().setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
            Bukkit.getLogger().info("Daylight cycle has been paused");
        }
    }
}
