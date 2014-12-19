package engine;

import gui.GameGUI;
import objects.Player;

/**
 * Created by Marko on 18.12.2014.
 */
public class Game {

    public Player player = new Player();
    public static String name = "Opponent" ;
    public static int basedmg;
    public static int health,playerHealth;

    public Game() {
        player.setName("Marko");
        int[] stats = {1,1,1,1};
        player.setStats(stats);
        player.setXP(0);
        playerHealth = player.getStats()[1]*10+100;
        generateOpponent();

        GameGUI gui = new GameGUI(player);
    }

    public static void attackAction() {
        playerHealth = playerHealth-basedmg;
        health = health-10;
    }

    private static void generateOpponent() {
        String[] namelist = {"Virgo","Rünno","Mart","Jaanus","Vallo"};
        basedmg = randomInteger(10,25);
        health = randomInteger(100,200);
        name = namelist[randomInteger(0,namelist.length-1)];
    }

    public static int randomInteger(int min, int max) {
        return (min+(int)(Math.random()*((max-min)+1)));
    }

}
