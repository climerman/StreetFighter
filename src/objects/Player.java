package objects;

import java.io.Serializable;

/**
 * Created by Marko on 18.12.2014.
 */
public class Player implements Serializable{
    String name;
    int[] stats = new int[3];
    int xp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getStats() {
        return stats;
    }

    public void setStats(int[] stats) {
        this.stats = stats;
    }

    public int getXP() {
        return xp;
    }

    public void setXP(int xp) {
        this.xp = xp;
    }
}
