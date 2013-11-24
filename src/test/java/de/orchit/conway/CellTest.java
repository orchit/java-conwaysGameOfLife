package de.orchit.conway;


import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class CellTest {

    @Test
    public void weHaveLivingCells(){
        assertTrue(new Cell().isAlive());
    }

    @Test
    public void weHaveDeadCells(){
        assertFalse(new Cell(false).isAlive());
    }

    private static class Cell {

        private boolean alive;

        private Cell() {
            alive = true;
        }

        public Cell(boolean isAlive) {
            alive=isAlive;
        }


        public boolean isAlive() {
            return alive;
        }
    }
}
