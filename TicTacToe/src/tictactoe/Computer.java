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

    public boolean aiTurn(int[][] b) {
        boolean moved = false;

        switch (aiLevel) {
            case 1:
                int r;
                int c;

                while (!moved) {
                    r = generateNumber(b.length) + 1;
                    c = generateNumber(b.length) + 1;

                    if (b[r - 1][c - 1] == 0 && b[r - 1][c - 1] != 1) {
                        b[r - 1][c - 1] = 2;
                        updateDisplay(b);
                        moved = true;
                    }
                }
        }

        return false;

    }

    public int generateNumber(int range) {
        Random number = new Random();
        int i = number.nextInt(range);
        return i;
    }

}
