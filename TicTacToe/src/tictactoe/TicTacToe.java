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
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();

        Scanner sc = new Scanner(System.in);

        int[][] board = new int[3][3];
        int rowInput, colInput;

        while (game.checkGame(board)) {
            boolean userMove = true;
            boolean cpMove = false;

            if (userMove) {
                System.out.println("Please input row number");
                rowInput = sc.nextInt();
                System.out.println("Please input column number");
                colInput = sc.nextInt();
                userMove(board, rowInput, colInput);
                updateConsole(board);
            }

        }

    }

    public static void userMove(int[][] b, int r, int c) {
        if (b[r - 1][c - 1] == 0) {
            b[r - 1][c - 1] = 1;
        } else {
            System.out.println("Please select a valid tile.");
        }

    }

    public static void updateConsole(int[][] b) {
        for (int i = 0; i < b.length; i++) {
            System.out.println(Arrays.toString(b[i]));
        }
    }

    public boolean checkGame(int[][] b) {
        for (int i = 0; i < b.length; i++) {
            return true;
        }
        return false;
    }

}
