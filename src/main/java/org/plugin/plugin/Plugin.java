package org.plugin.plugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.plugin.plugin.Listener.BlocksBreak;
import org.plugin.plugin.commands.tabs.ItemTab;
import org.plugin.plugin.commands.commands.Die;
import org.plugin.plugin.commands.commands.cor;
import org.plugin.plugin.Listener.PlayerMove;
import org.plugin.plugin.Listener.Player_Join_and_Leave;
import org.plugin.plugin.commands.commands.giveItem;
import org.plugin.plugin.db.ConnectSQL;

import java.util.Objects;

public final class Plugin extends JavaPlugin {


    private ConnectSQL database;
    @Override
    public void onEnable() {


        getServer().getPluginManager().registerEvents(new PlayerMove(), this);
        getServer().getPluginManager().registerEvents(new Player_Join_and_Leave(this), this);
        getServer().getPluginManager().registerEvents(new BlocksBreak(this), this);

        Objects.requireNonNull(getCommand("die")).setExecutor(new Die());
        Objects.requireNonNull(getCommand("cor")).setExecutor(new cor());
        Objects.requireNonNull(getCommand("giveitem")).setExecutor(new giveItem());
        Objects.requireNonNull(getCommand("giveitem")).setTabCompleter(new ItemTab());



        try {
            this.database = new ConnectSQL();
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
