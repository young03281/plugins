package org.plugin.plugin.Listener;

import org.plugin.plugin.db.ConnectSQL;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.plugin.plugin.Plugins;
import org.plugin.plugin.db.models.PlayerStats;

import java.sql.SQLException;

public class BlocksBreak implements Listener {
    private final Plugins plugin;

    public BlocksBreak(Plugins plugins) {
        this.plugin = plugins;
    }

    @EventHandler
    public void onBlocksBreak(BlockBreakEvent e) throws SQLException {
        Player p = e.getPlayer();
        ConnectSQL sql = new ConnectSQL();
        PlayerStats stats = sql.getPlayerStatsFromDataBase(p, this.plugin);
        stats.setBlocksBroken(stats.getBlocksBroken() + 1);
        this.plugin.getDatabase().updatePlayerStats(stats);

    }
}
