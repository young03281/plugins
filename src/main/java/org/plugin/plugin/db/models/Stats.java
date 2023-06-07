package org.plugin.plugin.db.models;

import java.util.Date;

public class Stats {

    private  String uuid;
    private int deaths;
    private int kills;
    private long blocksBroken;
    private Date LastLogin;

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

    public Stats(String uuid, int deaths, int kills, long blocksBroken, Date lastLogin) {
        this.uuid = uuid;
        this.deaths = deaths;
        this.kills = kills;
        this.blocksBroken = blocksBroken;
        LastLogin = lastLogin;
    }
}
