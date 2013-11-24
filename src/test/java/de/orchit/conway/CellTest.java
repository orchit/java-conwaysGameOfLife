package de.orchit.conway;


import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class CellTest {

    @Test
    public void weHaveLivingCells() {
        assertTrue(Cell.LIVING.isAlive());
    }

    @Test
    public void weHaveDeadCells() {
        assertFalse(Cell.DEAD.isAlive());
    }

    @Test
    public void aCellWith2NeighborsWillStayAliveAfterEvolve(){
        final Cell cell = Cell.LIVING;
        assertTrue(cell.evolve(2).isAlive());
    }

    private static class Cell {
        public static Cell LIVING = new Cell(true);
        public static Cell DEAD = new Cell(false);

        private boolean alive;

        private Cell(boolean isAlive) {
            alive = isAlive;
        }


        public boolean isAlive() {
            return alive;
        }

        public Cell evolve(int neighborCount) {
            return Cell.LIVING;
        }
    }
}
