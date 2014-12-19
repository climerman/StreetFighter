package gui;

import engine.Game;
import objects.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Marko on 18.12.2014.
 */
public class GameGUI extends JFrame {
    private JPanel panel;
    private JLabel nameLabel;
    private JLabel levelLabel;
    private JLabel xpLabel;
    private JLabel healthLabel;
    private JButton attackButton;
    private JButton escapeButton;
    private JLabel opNameLabel;
    private JLabel opHealthLabel;
    private JButton newButton;
    private JButton exitButton;


    public GameGUI(final Player player) {
        super("Streetfighter");
        setContentPane(panel);
        reloadContent(player);

        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.attackAction();
                reloadContent(player);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.saveAction();
                dispose();
            }
        });



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void reloadContent(Player player) {
        nameLabel.setText(player.getName());
        levelLabel.setText(Integer.toString(player.getStats()[0]));
        xpLabel.setText(Integer.toString(player.getXP()));
        healthLabel.setText(Integer.toString(Game.playerHealth));

        opNameLabel.setText(Game.name);
        opHealthLabel.setText(Integer.toString(Game.opHealth));
    }


}
