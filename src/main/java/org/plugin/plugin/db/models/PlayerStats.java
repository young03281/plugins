package org.plugin.plugin.db.models;

import java.util.Date;

public class PlayerStats {

    private String name;
    private String uuid;
    private int deaths;
    private int kills;
    private long blocksBroken;
    private Date LastLogin;

    public void setName(String name) {
        this.name = name;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public void setBlocksBroken(long blocksBroken) {
        this.blocksBroken = blocksBroken;
    }

    public void setLastLogin(Date lastLogin) {
        LastLogin = lastLogin;
    }

    public String getName(){
        return name;
    }

    public String getUuid() {
        return uuid;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getKills() {
        return kills;
    }

    public long getBlocksBroken() {
        return blocksBroken;
    }

    public Date getLastLogin() {
        return LastLogin;
    }


    public PlayerStats(String name, String uuid, int deaths, int kills, long blocksBroken, Date lastLogin) {
        this.name = name;
        this.uuid = uuid;
        this.deaths = deaths;
        this.kills = kills;
        this.blocksBroken = blocksBroken;
        LastLogin = lastLogin;
    }
}
