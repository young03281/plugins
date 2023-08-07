package org.plugin.plugin.Listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.plugin.plugin.Plugin;
import org.plugin.plugin.db.ConnectSQL;
import org.plugin.plugin.db.models.PlayerStats;

import java.sql.SQLException;
import java.util.Calendar;

public class Player_Join_and_Leave implements Listener{

    private Boolean kicked = false;
    private final Plugin plugin;
    public Player_Join_and_Leave(Plugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) throws SQLException {
        event.setJoinMessage(ChatColor.YELLOW +event.getPlayer().getDisplayName()+"幹不要再進來了我記憶體要爆了");
        ConnectSQL sql = new ConnectSQL(this.plugin);
        PlayerStats stats = sql.getPlayerStatsFromDataBase(event.getPlayer(), this.plugin);
        stats.setLastLogin(Calendar.getInstance());
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
