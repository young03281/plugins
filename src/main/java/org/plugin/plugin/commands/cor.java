package org.plugin.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.List;

public class cor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings){
        Collection playersC = Bukkit.getOnlinePlayers();
        List<Player> playerList = (List<Player>) playersC;
        Boolean  ShowOrNot = false;
        if(strings.length != 0){
            if(strings[0].equalsIgnoreCase("show")){
                ShowOrNot = true;
            }else{
                ShowOrNot = false;
            }
        }
        if( ShowOrNot || strings.length == 0) {
            commandSender.sendMessage("place cor :");
            commandSender.sendMessage("-47 70 433 portal(hell)");
            commandSender.sendMessage("all people's cor :");
            for (int i = 0; i < playerList.size(); i++) {
                Player a = playerList.get(i);
                Location aloc = a.getLocation();
                double x = (double) Math.round(aloc.getX() * 10) / 10;
                double y = (double) Math.round(aloc.getY() * 10) / 10;
                double z = (double) Math.round(aloc.getZ() * 10) / 10;
                commandSender.sendMessage(ChatColor.AQUA + a.getDisplayName() + ChatColor.GOLD + "(" + aloc.getWorld().getName() + ")" + ChatColor.RESET + ":" + x + " " + y + " " + z);
            }
        }else{
            if(s.equalsIgnoreCase("add")){
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
