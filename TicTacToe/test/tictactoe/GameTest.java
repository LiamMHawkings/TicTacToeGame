/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Liam
 */
public class GameTest {
    
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkGame method, of class Game.
     * Testing for 'rows' win condition.
     */
    @Test
    public void testCheckGame1() {
        System.out.println("checkGame");
        int[][] b = {{1,0,2},{2,2,0},{1,1,1}};
        
        Game instance = new Game(3);
        instance.board = b;
        
        int expResult = 1;
        int result = instance.checkGame(instance.board);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkGame method, of class Game.
     * Testing for 'diagonals' win condition.
     */
    @Test
    public void testCheckGame2() {
        System.out.println("checkGame");
        int[][] b = {{1,1,2,2},{0,0,2,1},{1,2,1,0},{2,1,0,0}};
        
        Game instance = new Game(4);
        instance.board = b;
        
        int expResult = 2;
        int result = instance.checkGame(instance.board);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkGame method, of class Game.
     * Testing for 'columns' win condition.
     */
    @Test
    public void testCheckGame3() {
        System.out.println("checkGame");
        int[][] b = {{2,1,1,2,0},{2,1,0,1,2},{0,1,1,2,0},{0,1,2,2,0},{2,1,2,2,0}};
        
        Game instance = new Game(5);
        instance.board = b;
        
        int expResult = 1;
        int result = instance.checkGame(instance.board);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkGame method, of class Game.
     * Testing for 'tie' win condition.
     */
    @Test
    public void testCheckGame4() {
        System.out.println("checkGame");
        int[][] b = {{1,2,1,2},{2,2,1,1},{1,2,1,1},{2,1,2,2}};
        
        Game instance = new Game(4);
        instance.board = b;
        
        int expResult = 3;
        int result = instance.checkGame(instance.board);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkGame method, of class Game.
     * Testing for continuation of game.
     */
    @Test
    public void testCheckGame5() {
        System.out.println("checkGame");
        int[][] b = {{1,0,0,2},{2,0,1,1},{0,2,0,1},{2,1,0,2}};
        
        Game instance = new Game(4);
        instance.board = b;
        
        int expResult = 0;
        int result = instance.checkGame(instance.board);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateDisplay method, of class Game.
     * Note: This method currently has no test condition.
     */
    @Test
    public void testUpdateDisplay() {
        System.out.println("updateDisplay");
        int[][] b = {{1,0,2},{2,2,0},{1,1,1}};
        Game.updateDisplay(b);
    }
    
}
