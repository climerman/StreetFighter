package engine;

import gui.GameGUI;
import objects.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import static engine.SaveSys.loadPlayer;
import static engine.SaveSys.saveLog;
import static engine.SaveSys.savePlayer;

/**
 * Created by Marko on 18.12.2014.
 */
public class Game implements Serializable {

    public static Player player = new Player();
    public static String name = "Opponent";
    public static int opHealth,opDamage;
    public static int xpTreshold = 50;
    public static ArrayList<String> log = new ArrayList<String>();

    public Game() {
        generateOpponent();
        loadAction();
        GameGUI gui = new GameGUI(player);
    }

    public static void newAction() {
        player.initPlayer();
    }

    public static void attackAction() {
        player.setHealth(player.getHealth()-opDamage);
        opHealth = opHealth - 10*player.getLevel();
        player.setXp(player.getXp() + randomInteger(2,10)*player.getLevel());
        generateLog();
        checkAction();
    }

    public static void saveAction() {
        savePlayer(player);
        saveLog(log);
    }

    public static void loadAction() {
        player = loadPlayer();
    }

    public static void levelAction() {
        player.setLevel(player.getLevel()+1);
        deathAction();
    }

    public static void deathAction() {
        player.setXp(0);
        player.setHealth(player.getLevel()*10+100);
    }

    public static void checkAction() {
        if (player.getXp()>=(player.getLevel()*xpTreshold))
            levelAction();

        if (player.getHealth()<=0) {
            deathAction();
        }

        if (opHealth <= 0) {
            newOpAction();
        }
    }

    public static void newOpAction() {
        generateOpponent();
    }

    private static void generateOpponent() {
        String[] namelist = {"Virgo","Rünno","Mart","Jaanus","Vallo"};
        opDamage = randomInteger(5*player.getLevel(),10*player.getLevel());
        opHealth = randomInteger(50+10*player.getLevel(),100+10*player.getLevel());
        name = namelist[randomInteger(0,namelist.length-1)];
    }

    private static void generateLog() {
        log.add(Calendar.getInstance().getTime().toString()+" -> Player: "+ player.getName()+
                "; Health: "+player.getHealth()+ "; Level: "+player.getLevel()+"; XP: "+player.getXp());
    }

    public static int randomInteger(int min, int max) {
        return (min+(int)(Math.random()*((max-min)+1)));
    }

}
