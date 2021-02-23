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
    public String[][] board;

    public Game(int size) {
        this.size = size;
        this.board = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = "";
            }
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
    public int checkGame(String[][] b) {
        //Check for 'rows' win condition
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length - 1; j++) {
                if (!b[i][j].equals("") && b[i][j].equals(b[i][j + 1])) {
                    if (j == b[0].length - 2) {
                        if (b[i][j].equals("X")) {
                            System.out.println("R1");
                            return 1;
                        } else if (b[i][j].equals("O")) {
                            System.out.println("R2");
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
                if (!b[j][i].equals("") && b[j][i].equals(b[j + 1][i])) {
                    if (j == b[0].length - 2) {
                        if (b[j][i].equals("X")) {
                            System.out.println("C1");
                            return 1;
                        } else if (b[j][i].equals("O")) {
                            System.out.println("C2");
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
            if (!b[i][i].equals("") && b[i][i].equals(b[i + 1][i + 1])) {
                if (i == b[0].length - 2) {
                    if (b[i][i].equals("X")) {
                        System.out.println("D1");
                        return 1;
                    } else if (b[i][i].equals("O")) {
                        System.out.println("D2");
                        return 2;
                    }
                }
            } else {
                break;
            }
        }

        //Check for 'reversed diagonals' win condition
        for (int i = 0; i < b.length - 1; i++) {
            if (!b[i][(b.length - 1) - i].equals("") && b[i][(b.length - 1) - i].equals(b[i + 1][(b.length - 2) - i])) {
                if (i == b[0].length - 2) {
                    if (b[0][(b.length - 1)].equals("X")) {
                        System.out.println("R-D1");
                        return 1;
                    } else if (b[0][(b.length - 1)].equals("O")) {
                        System.out.println("R-D2");
                        return 2;
                    }
                }
            } else {
                break;
            }
        }

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                if (b[i][j].equals("")) {
                    return 0;
                }
            }
        }

        return 3;

    }

    /**
     * Display method used to print the 2D Array for the game by printing rows
     * of said array using a for loop.
     *
     * @param b (board)
     */
    public void updateDisplay(String[][] b) {
        for (String[] row : b) {
            System.out.println(Arrays.toString(row));
        }
    }

}
