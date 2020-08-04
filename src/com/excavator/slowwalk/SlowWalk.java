package com.excavator.slowwalk;
import org.bukkit.plugin.java.JavaPlugin;

public class SlowWalk extends JavaPlugin{
	

    @Override
    public void onDisable() {
    }

    @Override
    public void onEnable() {
        getCommand("walk").setExecutor(new WalkCommand(this));
    }
	
}

