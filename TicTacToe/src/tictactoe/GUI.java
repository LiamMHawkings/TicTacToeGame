/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Liam
 */
public class GUI implements ActionListener {

    Game game = new Game(3); //Creating game object with array field specified.
    User user = new User(game.size); //Creating user object as extension of Game class.
    Computer ai = new Computer(game.size, 1); //Creating computer object as extension of Game class.

    JButton[][] tiles;
    boolean userTurn;

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.runGame();
    }

    /**
     * Constructor for initialsing the GUI, creates the necessary JSwing
     * objects, and class methods to create the view.
     */
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

    /**
     * Method used to create a 2D array of JButtons, representing each tile of
     * the game board as a clickable button with a prescribed action listener
     * method.
     *
     * @param panel
     */
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

    /**
     * 'Main' method for running the game. A continuous loop is used to
     * constantly check and update the display with each move made by the player
     * or AI. When a win condition is finally met, the respective 'pop-up'
     * message is shown for the result of the game.
     */
    public void runGame() {
        userTurn = true;

        //Loop until win condition is met
        while (game.checkGame(game.board) == 0) {
            while (!userTurn && game.checkGame(game.board) != 1) {
                ai.aiTurn(game.board);
                userTurn = true;
            }
            updateBoard();

        }

        updateBoard();
        int message = 0;

        //Game ends when loop breaks
        switch (game.checkGame(game.board)) {
            case 1:
                message = JOptionPane.showConfirmDialog(null, "Player Wins!"
                        + "\n" + "Do you want to play again?", "Game Over!", JOptionPane.YES_NO_OPTION);
                break;
            case 2:
                message = JOptionPane.showConfirmDialog(null, "Computer Wins!"
                        + "\n" + "Do you want to play again?", "Game Over!", JOptionPane.YES_NO_OPTION);
                break;
            case 3:
                message = JOptionPane.showConfirmDialog(null, "No More Moves! Tie!"
                        + "\n" + "Do you want to play again?", "Game Over!", JOptionPane.YES_NO_OPTION);
                break;
            default:
                break;
        }

        if (message == JOptionPane.YES_OPTION) {
            resetBoard();
            runGame(); //recursive method used to reset the game.
        } else {
            System.exit(0);
        }

    }

    /**
     * Method used to update the UI view with any new changes made to the game
     * board, on the respective JButton tile.
     */
    public void updateBoard() {
        for (int i = 0; i < game.size; i++) {
            for (int j = 0; j < game.size; j++) {
                if (game.board[i][j].equals("X") && !tiles[i][j].getText().equals("X")) {
                    tiles[i][j].setText("X");
                    tiles[i][j].setEnabled(false);
                }
                if (game.board[i][j].equals("O") && !tiles[i][j].getText().equals("O")) {
                    tiles[i][j].setText("O");
                    tiles[i][j].setEnabled(false);
                }
            }
        }
    }

    /**
     * Method clears all String declarations of the game board, by reseting them
     * to their default value, as well as the respective JButton tiles.
     */
    public void resetBoard() {
        for (int i = 0; i < game.size; i++) {
            for (int j = 0; j < game.size; j++) {
                game.board[i][j] = "";
                tiles[i][j].setText("");
                tiles[i][j].setEnabled(true);
            }
        }
    }

    /**
     * ActionListener method for carrying out prescribed functionality whenever
     * a JButton (tile) object is accessed.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (userTurn) {
            for (int i = 0; i < game.size; i++) {
                for (int j = 0; j < game.size; j++) {
                    if (e.getSource() == tiles[i][j]) {
                        if (!tiles[i][j].getText().equals("X") || !tiles[i][j].getText().equals("O")) {
                            game.board[i][j] = "X";
                            userTurn = false;
                        }
                    }
                }
            }
        }
    }
}
