package org.plugin.plugin.db;

import org.bukkit.entity.Player;
import org.plugin.plugin.Plugin;
import org.plugin.plugin.db.models.PlayerStats;

import java.sql.*;
import java.util.Calendar;


public class ConnectSQL {

    private Connection connection;

    public ConnectSQL(){

    }
    public Connection getConnection() throws SQLException {

        if (connection != null) {
            return connection;
        }

        String url = "jdbc:mysql+srv://_mysql._tcp.mysql.young922.com";
        String DBurl = "jdbc:mysql+srv://_mysql._tcp.mysql.young922.com/minecraft_data";
        String user = "root";
        String pwd = "11220328";

        try {
            this.connection = DriverManager.getConnection(url, user, pwd);
            System.out.println("Connected to mysql");
            try {
                this.connection = DriverManager.getConnection(DBurl, user, pwd);
                System.out.println("Connected to database");
            } catch (SQLException ee) {
                System.out.println("cant connect to DB");
                try {
                    this.connection = DriverManager.getConnection(url, user, pwd);
                    Statement statement = this.connection.createStatement();
                    String CreateDatabase = "CREATE DATABASE IF NOT EXISTS minecraft_data";
                    statement.execute(CreateDatabase);
                    statement.close();
                    this.connection = DriverManager.getConnection(DBurl, user, pwd);
                    System.out.println("Connected and created the database");
                } catch (SQLException eee) {
                    System.out.println("can't create");
                    eee.printStackTrace();
                }
            }
        } catch (SQLException e) {
            System.out.println("can't connect to mysql");
            e.printStackTrace();
        }
        return this.connection;
    }
    public void createStats() throws SQLException {
        try {
            Statement statement = getConnection().createStatement();
            String player_stats = "CREATE TABLE IF NOT EXISTS player_stats(name varchar(50) ,uuid varchar(40) primary key, deaths int, kills int, BlocksBroken int, LastLogin DATE)";
            String cor = "CREATE TABLE IF NOT EXISTS coordinates(place varchar(100) primary key, x double, y double, z double)";
            statement.execute(player_stats);
            statement.execute(cor);

            statement.close();

            System.out.println("success to create table");

        } catch (SQLException e) {
            System.out.println("unable to create table");

            e.printStackTrace();
        }
    }

    public PlayerStats findPlayerByUUID(String uuid) throws SQLException {

        PreparedStatement statement = getConnection().
                prepareStatement("SELECT * FROM player_stats WHERE uuid = ?");
        statement.setString(1, uuid);
        ResultSet result = statement.executeQuery();

        while(result.next()){

            String name = result.getString("name");
            int death = result.getInt("deaths");
            int kills = result.getInt("kills");
            long BlocksBroken = result.getLong("BlocksBroken");
            Calendar LastLogin = Calendar.getInstance();
            LastLogin.setTime(result.getDate("LastLogin"));

            PlayerStats playerStats = new PlayerStats(name, uuid, death, kills, BlocksBroken, LastLogin);

            statement.close();

            return playerStats;
        }

        statement.close();
        return null;

    }

    public void createPlayerStats(PlayerStats stats) throws SQLException{


        PreparedStatement preparedStatement = getConnection().
                prepareStatement("INSERT INTO player_stats(name, uuid, deaths, kills, BlocksBroken, LastLogin) VALUES (?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, stats.getName());
        preparedStatement.setString(2, stats.getUuid());
        preparedStatement.setInt(3, stats.getDeaths());
        preparedStatement.setInt(4, stats.getKills());
        preparedStatement.setLong(5, stats.getBlocksBroken());
        preparedStatement.setDate(6, new java.sql.Date(stats.getLastLogin().getTime().getTime()));

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void updatePlayerStats(PlayerStats stats) throws SQLException{


        PreparedStatement preparedStatement = getConnection().
                prepareStatement("UPDATE player_stats Set name = ?, deaths = ?, kills = ?, BlocksBroken = ?, LastLogin = ? WHERE uuid = ?");
        preparedStatement.setString(1, stats.getName());
        preparedStatement.setInt(2, stats.getDeaths());
        preparedStatement.setInt(3, stats.getKills());
        preparedStatement.setLong(4, stats.getBlocksBroken());
        preparedStatement.setDate(5, new java.sql.Date(stats.getLastLogin().getTime().getTime()));
        preparedStatement.setString(6, stats.getUuid());

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    public PlayerStats getPlayerStatsFromDataBase(Player p, Plugin plugin) throws SQLException{

        PlayerStats stats = plugin.getDatabase().findPlayerByUUID(p.getUniqueId().toString());

        if(stats == null) {

            stats = new PlayerStats(p.getDisplayName(), p.getUniqueId().toString(), 0, 0, 0, Calendar.getInstance()
            );

            plugin.getDatabase().createPlayerStats(stats);

        }

        return stats;
    }


}
