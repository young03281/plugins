package org.plugin.plugin.commands.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.plugin.plugin.utils.UtilList;

import java.util.*;

public class giveItem implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender.hasPermission("plugin.CanUseGive") ){
            List<ItemStack> items = UtilList.getUtilList();
                if(strings.length == 1 || strings.length == 2){
                    Player p;
                    if(commandSender instanceof Player player){
                        p = player;
                        if(strings.length == 2){
                            p = Bukkit.getPlayerExact(strings[1]);
                            if(p == null){
                                commandSender.sendMessage(ChatColor.RED + "theres no this player");
                                return  false;
                            }
                        }
                    }else{
                        if(strings.length == 1){
                            commandSender.sendMessage(ChatColor.RED + "u have to use this with 2 args");
                                return false;
                        }else{
                            p = Bukkit.getPlayerExact(strings[1]);
                            if(p == null){
                                commandSender.sendMessage(ChatColor.RED + "theres no this player");
                                return false;
                            }
                        }
                    }
                    for(ItemStack item : items){
                            if(Objects.requireNonNull(item.getItemMeta()).getLocalizedName().equals(strings[0])) {
                                p.getInventory().addItem(item);
                                commandSender.sendMessage("give " + p.getDisplayName() + " " + Objects.requireNonNull(Objects.requireNonNull(item.getItemMeta()).getDisplayName()) + ChatColor.RESET + " *1");
                            }else{
                                commandSender.sendMessage(ChatColor.RED + "there's no this thing");
                                return false;
                            }

                    }
                }else{
                    commandSender.sendMessage(ChatColor.RED + "u have 2 use this with 1 or 2 args");
                    return false;
                }
        }else{
            commandSender.sendMessage(ChatColor.RED + "u cant use this");
        }

        return true;
    }
}
