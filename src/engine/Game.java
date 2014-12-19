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

    public Game() {
        loadAction();
        generateOpponent();
        GameGUI gui = new GameGUI(player);
    }

    public static void attackAction() {
        playerHealth = playerHealth-basedmg;
        opHealth = opHealth -10;
        player.setXP(player.getXP()+2);
    }

    public static void saveAction() {
        savePlayer(player);
    }

    public static void loadAction() {
        player = loadPlayer();
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
