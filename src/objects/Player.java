package objects;

import java.io.Serializable;

/**
 * Created by Marko on 18.12.2014.
 */
public class Player implements Serializable{
    String name;
    int xp, level, health;

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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void initPlayer() {
        setName("Marko");
        setLevel(1);
        setXp(0);
        setHealth(100);
    }
}
