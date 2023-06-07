package org.plugin.plugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.plugin.plugin.commands.Die;
import org.plugin.plugin.commands.cor;
import org.plugin.plugin.event.PlayerMove;
import org.plugin.plugin.event.Player_Join_and_Leave;
import org.plugin.plugin.db.ConnectSQL;

public final class Plugins extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerMove(), this);
        getServer().getPluginManager().registerEvents(new Player_Join_and_Leave(), this);

        getCommand("die").setExecutor(new Die());
        getCommand("cor").setExecutor(new cor());

        try {
            ConnectSQL db = new ConnectSQL();
            db.createStats();
        }catch(Exception ex){
            System.out.println("failed");
            ex.printStackTrace();
        }

    }

    @Override
    public void onDisable() {

    }


}
