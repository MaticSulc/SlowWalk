package com.excavator.slowwalk;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WalkCommand implements CommandExecutor {
    SlowWalk plugin;

    public WalkCommand(SlowWalk plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        String cmdName = cmd.getName().toLowerCase();
        Player player = (Player)sender;
        
        if(cmdName.equals("walk") && args.length == 1 && isValidNum(args[0])){
        	sender.sendMessage(ChatColor.AQUA + "Setting your walking speed to " + ChatColor.GREEN + args[0] + ". ");
        	float newSpeed = 0.2f * Float.parseFloat(args[0]);
            player.setWalkSpeed(newSpeed);

        	
        }
        
        else {
        	sender.sendMessage(ChatColor.RED + "Usage: /walk <0.0 - 1.0>");
            return true;
        }


        return true;
    }
    
    public static boolean isValidNum(String s) {
        try {
            float num = Float.parseFloat(s);
            if(num > 1 || num < 0) return false;
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
