package org.plugin.plugin.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.plugin.plugin.db.ConnectSQL;

public class PlayerMove implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        if(!player.hasPermission("plugin.canMove")){
            event.setCancelled(true);
        }
    }
}
