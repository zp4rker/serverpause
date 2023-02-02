package com.zp4rker.serverpause;

import org.bukkit.GameRule;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        if (getServer().getOnlinePlayers().size() == 0) {
            if (Boolean.TRUE.equals(getServer().getWorlds().get(0).getGameRuleValue(GameRule.DO_DAYLIGHT_CYCLE))) {
                getServer().getWorlds().get(0).setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
                getLogger().info("Daylight cycle has been paused");
            }
        }
    }
}
