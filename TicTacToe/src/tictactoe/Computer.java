/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Random;

/**
 *
 * @author Liam
 */
public class Computer extends Game {

    public int aiLevel;

    public Computer(int size, int level) {
        super(size);
        this.aiLevel = level;
    }

    public void easyMove(String[][] b) {
        boolean moved = false;

        int r;
        int c;

        while (!moved) {
            r = generateNumber(b.length) + 1;
            c = generateNumber(b.length) + 1;

            //System.out.println("r = " + r + " c = " + c);
            
            if (b[r - 1][c - 1].equals("") && !b[r - 1][c - 1].equals("X")) {
                b[r - 1][c - 1] = "O";
                moved = true;
            }
        }
    }

    /**
     * Boolean method containing computer logic of varying levels based on
     * difficulty chosen (via local variable in switch statement).
     *
     * @param b
     * @return
     */
    public boolean aiTurn(String[][] b) {
        switch (this.aiLevel) {
            case 1:
                easyMove(b);
                break;
        }

        return true;
    }

    /**
     * Creates an instance of the random class library, which is used to
     * generate an integer of a specified range.
     *
     * @param range
     * @return i
     */
    public int generateNumber(int range) {
        Random number = new Random();
        int i = number.nextInt(range);
        return i;
    }

}
