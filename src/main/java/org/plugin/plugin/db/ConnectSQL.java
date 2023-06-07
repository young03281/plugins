package org.plugin.plugin.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectSQL {

    private Connection connection;
    public Connection getConnection() throws SQLException{

        if(connection != null){
            return connection;
        }

        String url = "jdbc:mysql://localhost/data";
        String user = "root";
        String pwd = "";

        try {
            this.connection = DriverManager.getConnection(url, user, pwd);

            System.out.println("Connected");
        } catch (SQLException e) {
            System.out.println("can't connect");
            e.printStackTrace();
        }
        return this.connection;
    }
    public void createStats() throws SQLException{
        try{
            Statement statement = getConnection().createStatement();
            String player_stats = "CREATE TABLE IF NOT EXISTS player_stats(uuid varchar(40) primary key, deaths int, kills int, BlocksBroken int, LastLogin DATE)";
            String cor = "CREATE TABLE IF NOT EXISTS coordinates(place varchar(100) primary key, x double, y double, z double)";
            statement.execute(player_stats);
            statement.execute(cor);

            statement.close();

            System.out.println("success to create table");

        }catch(SQLException e){
            System.out.println("unable to create table");

            e.printStackTrace();
        }
    }

}
