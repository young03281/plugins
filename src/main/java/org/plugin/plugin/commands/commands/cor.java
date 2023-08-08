package org.plugin.plugin.commands.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class cor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings){
        Collection playersC = Bukkit.getOnlinePlayers();
        List<Player> playerList = (List<Player>) playersC;
        boolean ShowOrNot = false;
        if(strings.length != 0){
            if(strings[0].equalsIgnoreCase("show")){
                ShowOrNot = true;
            }
        }
        if( ShowOrNot || strings.length == 0) {
            commandSender.sendMessage("place cor :");
            commandSender.sendMessage("all people's cor :");
            for (Player a : playerList) {
                Location Al = a.getLocation();
                double x = (double) Math.round(Al.getX() * 10) / 10;
                double y = (double) Math.round(Al.getY() * 10) / 10;
                double z = (double) Math.round(Al.getZ() * 10) / 10;
                commandSender.sendMessage(ChatColor.AQUA + a.getDisplayName() + ChatColor.GOLD + "(" + Objects.requireNonNull(Al.getWorld()).getName() + ")" + ChatColor.RESET + ":" + x + " " + y + " " + z);
            }
        }else{
            if(strings[1].equalsIgnoreCase("add")){
                if(commandSender instanceof Player){
                    Player player = (Player) commandSender;
                    if(!player.hasPermission("plugin.can_add_cor")){
                        return false;
                    }
                }

            }
        }
        return false;
    }
}
