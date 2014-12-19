package objects;

import java.io.Serializable;

/**
 * Created by Marko on 18.12.2014.
 */
public class Player implements Serializable{
    String name;
    int xp, level, str, sta;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getSta() {
        return sta;
    }

    public void setSta(int sta) {
        this.sta = sta;
    }

    public void initPlayer() {
        setName("Marko");
        setLevel(1);
        setSta(1);
        setStr(1);
        setXp(0);
    }
}
