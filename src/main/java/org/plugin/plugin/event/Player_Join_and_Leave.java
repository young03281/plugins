package org.plugin.plugin.event;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Player_Join_and_Leave implements Listener{

    private Boolean kicked;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        event.setJoinMessage(ChatColor.YELLOW +event.getPlayer().getDisplayName()+"幹不要再進來了我記憶體要爆了");
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        if (kicked) {
        } else {
            event.setQuitMessage(ChatColor.YELLOW + event.getPlayer().getDisplayName() + "死好滾");
        }
    }

    @EventHandler
    public void onPlayerKick(PlayerKickEvent event){
        kicked = true;
        event.setLeaveMessage("" +ChatColor.BOLD + ChatColor.YELLOW + event.getPlayer().getDisplayName() + "太白目,被踢了");
        event.setReason("媽的爛死");
    }
}
