/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 * TicTacToe Game
 *
 * @author Liam
 */
public class TicTacToe {

    /**
     * Main method instantiates a class object used to call external methods.
     * The game is setup before various conditional statements and method
     * calling are used to provide necessary functionality.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Game game = new Game(3); //Creating game object with array field specified.
        User user = new User(game.size); //Creating user object as extension of Game class.
        Computer ai = new Computer(game.size, 1); //Creating computer object as extension of Game class.

        System.out.println("TIC TAC TOE");

        boolean userMove = true;
        boolean cpMove = false;

        while (game.checkGame(game.board) == 0) {
            if (userMove && !cpMove) {
                while (!user.userTurn(game.board)) {
                }
                userMove = false;
                cpMove = true;
            }

            if (game.checkGame(game.board) != 0) {
                break;
            }

            if (!userMove && cpMove) {
                System.out.println("Computer's turn...");
                while (ai.aiTurn(game.board)) {
                }
                userMove = true;
                cpMove = false;
            }

        }

        //Game ends win loop breaks
        switch (game.checkGame(game.board)) {
            case 1:
                System.out.println("Game Over! Player Wins!");
                break;
            case 2:
                System.out.println("Game Over! Computer Wins!");
                break;
            case 3:
                System.out.println("No More Moves! Tie!");
                break;
            default:
                break;
        }

    }
}
