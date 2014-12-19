package engine;

import objects.Player;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Marko on 19.12.2014.
 */
public class SaveSys {
    static final String PATH="C:\\Users\\Marko\\Documents\\StreetFighter/player.sav";

    public static void savePlayer(Player player) {
        try {
            System.out.println("[Sys] Player save in progress...");
            FileOutputStream fout = new FileOutputStream(PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(player);
            oos.close();
            System.out.println("[Sys] Player save completed successfully!");
        } catch (Exception e) {
            System.out.println("[Sys] Player save interrupted by error: ");
            e.printStackTrace();
        }
    }

    public static Player loadPlayer() {
        Player player = new Player();
        try {
            System.out.println("[Sys] Player load in progress..");
            FileInputStream fin = new FileInputStream(PATH);
            ObjectInputStream ois = new ObjectInputStream(fin);
            player = (Player)ois.readObject();
            ois.close();
            System.out.println("[Sys] Player load completed successfully!");
            return player;
        } catch (Exception e) {
            System.out.println("[Sys] Player save interrupted by error: ");
            e.printStackTrace();
            return null;
        }
    }
}
