package org.plugin.plugin.commands.tabs;

import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import org.plugin.plugin.utils.UtilList;
import org.bukkit.command.Command;

import java.util.ArrayList;
import java.util.List;

public class ItemTab implements TabCompleter{
    private static List<String> COMMANDS = new ArrayList<>();
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        final List<String> completions = new ArrayList<>();
        if(args.length == 1){
            COMMANDS = UtilList.getItemName();
            StringUtil.copyPartialMatches(args[0], COMMANDS, completions);
            return completions;
        }
        if(args.length == 2){
            for(Player p : org.bukkit.Bukkit.getOnlinePlayers()){
                COMMANDS.clear();
                COMMANDS.add(p.getDisplayName());
                StringUtil.copyPartialMatches(args[1], COMMANDS, completions);
                return completions;
            }
        }
        return completions;
    }
}
