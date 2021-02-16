/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

/**
 * TicTacToe Game
 * @author Liam
 */
public class TicTacToe {

    /**
     * Main method instantiates a class object used to call external methods.
     * The game is setup before various conditional statements and method
     * calling are used to provide necessary functionality.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();

        int size = 3;
        int[][] board = new int[size][size];

        System.out.println("TIC TAC TOE");
        updateDisplay(board);

        while (game.checkGame(board)) {
            boolean userMove = true;
            boolean cpMove = false;

            if (userMove && !cpMove) {
                while (!game.userTurn(board)) {
                }
                userMove = false;
                cpMove = true;
            }

            if (!userMove && cpMove) {
                System.out.println("Computer's turn...");
            }

        }

        //Game ends win loop breaks
        System.out.println("Game Over!");

    }

    /**
     * Boolean method containing the logic for user input as well as processing
     * said input and returning a variable on a valid/invalid input.
     *
     * @param b
     * @return true (to complete turn), false (to retry)
     */
    public boolean userTurn(int[][] b) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please input row number");
        int r = sc.nextInt();
        System.out.println("Please input column number");
        int c = sc.nextInt();

        if (b[r - 1][c - 1] == 0) {
            b[r - 1][c - 1] = 1;
            updateDisplay(b);
            return true;
        } else {
            System.out.println("ERROR: Please select a valid tile.");
            return false;
        }

    }

    /**
     * Display method used to print the 2D Array for the game by printing rows
     * of said array using a for loop.
     *
     * @param b (board)
     */
    public static void updateDisplay(int[][] b) {
        for (int[] row : b) {
            System.out.println(Arrays.toString(row));
        }
    }

    /**
     * Boolean method used to run through the various win conditions for Tic Tac
     * Toe (rows, columns, diagonals). Method is ambiguous and can be used to
     * solve for any size game by sorting through the 2D array defined for the
     * game as a nested for loop.
     *
     * @param b (board)
     * @return true (to continue game). false (to end game)
     */
    public boolean checkGame(int[][] b) {
        //Check for 'rows' win condition
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length - 1; j++) {
                if (b[i][j] != 0 && b[i][j] == b[i][j + 1]) {
                    if (j == b[0].length - 2) {
                        return false;
                    }
                } else {
                    break;
                }
            }
        }

        //Check for 'cols' win condition
        for (int i = 0; i < b.length - 1; i++) {
            for (int j = 0; j < b[0].length; j++) {
                if (b[i][j] != 0 && b[i][j] == b[i + 1][j]) {
                    if (i == b[0].length - 2) {
                        return false;
                    }
                } else {
                    break;
                }
            }
        }

        //Check for 'diagonals' win condition
        for (int i = 0; i < b.length - 1; i++) {
            if (b[i][i] != 0 && b[i][i] == b[i + 1][i + 1]) {
                if (i == b[0].length - 2) {
                    return false;
                }
            } else if (b[i][i] != 0 && b[(b.length - 1)][(b.length - 1)] == b[(b.length - 1) - i][(b.length - 1) - i]) {
                if (i == b[0].length - 2) {
                    return false;
                } else {
                    break;
                }
            }
        }

        return true;
    }

}
