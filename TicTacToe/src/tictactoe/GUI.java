/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Liam
 */
public class GUI implements ActionListener {

    Game game = new Game(5); //Creating game object with array field specified.
    User user = new User(game.size); //Creating user object as extension of Game class.
    Computer ai = new Computer(game.size, 1); //Creating computer object as extension of Game class.

    JButton[][] tiles;

    public static void main(String[] args) {
        GUI gui = new GUI();
    }

    public GUI() {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        initialiseBoard(panel);

        frame.setVisible(true);
    }

    private void initialiseBoard(JPanel panel) {
        tiles = new JButton[game.size][game.size];

        panel.setLayout(new GridLayout(game.size, game.size));
        for (int i = 0; i < game.size; i++) {
            for (int j = 0; j < game.size; j++) {
                tiles[i][j] = new JButton();
                tiles[i][j].addActionListener(this);
                tiles[i][j].setSize(50, 50);
                panel.add(tiles[i][j]);
            }
        }
    }

    public boolean checkTurn() {
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < game.size; i++) {
            for (int j = 0; j < game.size; j++) {
                if (e.getSource() == tiles[i][j]) {
                    if (!tiles[i][j].getText().equals("X") || !tiles[i][j].getText().equals("O")) {
                        tiles[i][j].setText("X");
                    }
                }
            }
        }
    }
}
