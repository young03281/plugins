package org.plugin.plugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.plugin.plugin.Listener.BlocksBreak;
import org.plugin.plugin.commands.Die;
import org.plugin.plugin.commands.cor;
import org.plugin.plugin.Listener.PlayerMove;
import org.plugin.plugin.Listener.Player_Join_and_Leave;
import org.plugin.plugin.db.ConnectSQL;

public final class Plugins extends JavaPlugin {


    private ConnectSQL database;
    @Override
    public void onEnable() {


        getServer().getPluginManager().registerEvents(new PlayerMove(), this);
        getServer().getPluginManager().registerEvents(new Player_Join_and_Leave(), this);
        getServer().getPluginManager().registerEvents(new BlocksBreak(this), this);

        getCommand("die").setExecutor(new Die());
        getCommand("cor").setExecutor(new cor());


        try {
            this.database = new ConnectSQL(this);
            database.createStats();
        }catch(Exception ex){
            System.out.println("failed");
            ex.printStackTrace();
        }

    }

    public ConnectSQL getDatabase() {
        return database;
    }
}
