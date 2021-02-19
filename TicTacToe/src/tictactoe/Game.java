/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Arrays;

/**
 *
 * @author Liam
 */
public class Game {

    public int size;
    public int[][] board;

    public Game(int size) {
        this.size = size;
        this.board = new int[size][size];
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
    public int checkGame(int[][] b) {
        //Check for 'rows' win condition
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length - 1; j++) {
                if (b[i][j] != 0 && b[i][j] == b[i][j + 1]) {
                    if (j == b[0].length - 2) {
                        if (b[i][j] == 1) {
                            //System.out.println("R1");
                            return 1;
                        } else if (b[i][j] == 2) {
                            //System.out.println("R2");
                            return 2;
                        }
                    }
                } else {
                    break;
                }
            }
        }

        //Check for 'cols' win condition
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length - 1; j++) {
                if (b[j][i] != 0 && b[j][i] == b[j + 1][i]) {
                    if (j == b[0].length - 2) {
                        if (b[j][i] == 1) {
                            //System.out.println("C1");
                            return 1;
                        } else if (b[j][i] == 2) {
                            //System.out.println("C2");
                            return 2;
                        }
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
                    if (b[i][i] == 1) {
                        //System.out.println("D1");
                        return 1;
                    } else if (b[i][i] == 2) {
                        //System.out.println("D2");
                        return 2;
                    }
                }
            } else if (b[i][(b.length - 1) - i] != 0 && b[i][(b.length - 1) - i] == b[i + 1][(b.length - 2) - i]) {
                if (i == b[0].length - 2) {
                    if (b[0][(b.length - 1)] == 1) {
                        //System.out.println("rD1");
                        return 1;
                    } else if (b[0][(b.length - 1)] == 2) {
                        //System.out.println("rD2");
                        return 2;
                    }
                }
            } else {
                break;
            }
        }

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                if (b[i][j] == 0) {
                    return 0;
                }
            }
        }

        return 3;

    }

    /**
     * Display method used to print the 2D Array for the game by printing rows
     * of said array using a for loop.
     * @param b (board)
     */
    public static void updateDisplay(int[][] b) {
        for (int[] row : b) {
            System.out.println(Arrays.toString(row));
        }
    }

}
