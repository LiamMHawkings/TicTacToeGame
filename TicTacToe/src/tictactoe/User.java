/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Liam
 */
public class User extends Game {

    public User(int size) {
        super(size);
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

        int r, c;
        
        try {
            System.out.println("Please input row number");
            r = sc.nextInt();

            while (r < 0 || r > b.length) {
                System.out.println("Input must be within 1 and " + b.length);
                r = sc.nextInt();
            }

            System.out.println("Please input column number");
            c = sc.nextInt();

            while (c < 0 || c > b[0].length) {
                System.out.println("Input must be within 1 and " + b[0].length);
                c = sc.nextInt();
            }
        } catch (InputMismatchException ex) {
            System.out.println("Invalid input, please try again");
            return false;
        }

        if (b[r - 1][c - 1] == 0) {
            b[r - 1][c - 1] = 1;
            updateDisplay(b);
            return true;
        } else {
            System.out.println("ERROR: Please select an open tile.");
            return false;
        }

    }
}
