package engine;

import gui.GameGUI;
import objects.Player;

import static engine.SaveSys.loadPlayer;
import static engine.SaveSys.savePlayer;

/**
 * Created by Marko on 18.12.2014.
 */
public class Game {

    public static Player player = new Player();
    public static String name = "Opponent" ;
    public static int basedmg;
    public static int opHealth,playerHealth;
    public static int xpTreshold = 50;

    public Game() {
        generateOpponent();
        loadAction();
        GameGUI gui = new GameGUI(player);
    }

    public static void newAction() {
        player.initPlayer();
    }

    public static void attackAction() {
        playerHealth = playerHealth-basedmg;
        opHealth = opHealth -10;
        player.setXp(player.getXp() + 2);
        checkAction();
    }

    public static void saveAction() {
        savePlayer(player);
    }

    public static void loadAction() {
        player = loadPlayer();
    }

    public static void levelAction() {
        player.setLevel(player.getLevel()+1);
        player.setXp(0);
    }

    public static void checkAction() {
        if (player.getXp()>=(player.getLevel()*xpTreshold))
            levelAction();
    }

    public static void newOpAction() {
        generateOpponent();
    }

    private static void generateOpponent() {
        String[] namelist = {"Virgo","Rünno","Mart","Jaanus","Vallo"};
        basedmg = randomInteger(10,25);
        opHealth = randomInteger(100,200);
        name = namelist[randomInteger(0,namelist.length-1)];
    }

    public static int randomInteger(int min, int max) {
        return (min+(int)(Math.random()*((max-min)+1)));
    }

}
