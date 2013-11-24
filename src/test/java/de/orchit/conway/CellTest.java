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
    public void aLivingCellWith1NeighborWillDieAfterEvolve(){
        final Cell cell = Cell.LIVING;
        assertFalse(cell.evolve(1).isAlive());
    }

    @Test
    public void aLivingCellWith2NeighborsWillStayAliveAfterEvolve(){
        final Cell cell = Cell.LIVING;
        assertTrue(cell.evolve(2).isAlive());
    }

    @Test
    public void aLivingCellWith3NeighborsWillStayAliveAfterEvolve(){
        final Cell cell = Cell.LIVING;
        assertTrue(cell.evolve(3).isAlive());
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
            if(neighborCount==1) return Cell.DEAD;
            return Cell.LIVING;
        }
    }
}
