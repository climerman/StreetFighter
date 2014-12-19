package engine;

import objects.Player;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Marko on 19.12.2014.
 */
public class SaveSys {
    static final String PATH="C:\\Users\\Marko\\Documents\\StreetFighter/player.sav";
    static final String LOG_PATH="C:\\Users\\Marko\\Documents\\StreetFighter/log.txt";

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
            System.out.println("[Sys] Player load interrupted by error: ");
            e.printStackTrace();
            player = new Player();
            return player;
        }
    }

    public static void saveLog(ArrayList<String> log) {
        try {
            System.out.println("[Sys] Log append in progress..");
            File file = new File(LOG_PATH);
            if(!file.exists())
                file.createNewFile();
            FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("\n---");
            for (String line : log) {
                bw.write("\n"+line);
            }
            bw.close();
            System.out.println("[Sys] Log append completed.");
        } catch (Exception e) {
            System.out.println("[Sys] Log append interrupted: ");
            e.printStackTrace();
        }
    }
}
