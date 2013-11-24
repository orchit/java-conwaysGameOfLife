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
    public void aLivingCellWith0NeighborsWillDieAfterEvolve(){
        final Cell cell = Cell.LIVING;
        assertFalse(cell.evolve(0).isAlive());
    }

    @Test
    public void aDeadCellWith0NeighborsWillStayDeadAfterEvolve(){
        final Cell cell = Cell.DEAD;
        assertFalse(cell.evolve(0).isAlive());
    }

    @Test
    public void aLivingCellWith1NeighborWillDieAfterEvolve(){
        final Cell cell = Cell.LIVING;
        assertFalse(cell.evolve(1).isAlive());
    }

    @Test
    public void aDeadCellWith1NeighborWillStayDeadAfterEvolve(){
        final Cell cell = Cell.DEAD;
        assertFalse(cell.evolve(1).isAlive());
    }

    @Test
    public void aLivingCellWith2NeighborsWillStayAliveAfterEvolve(){
        final Cell cell = Cell.LIVING;
        assertTrue(cell.evolve(2).isAlive());
    }

    @Test
    public void aDeadCellWith2NeighborsWillStayDeadAfterEvolve(){
        final Cell cell = Cell.DEAD;
        assertFalse(cell.evolve(2).isAlive());
    }

    @Test
    public void aLivingCellWith3NeighborsWillStayAliveAfterEvolve(){
        final Cell cell = Cell.LIVING;
        assertTrue(cell.evolve(3).isAlive());
    }

    @Test
    public void aDeadCellWith3NeighborsWillBeRebornAfterEvolve(){
        final Cell cell = Cell.DEAD;
        assertTrue(cell.evolve(3).isAlive());
    }

    @Test
    public void aLivingCellWith4NeighborsWillDieAfterEvolve(){
        final Cell cell = Cell.LIVING;
        assertFalse(cell.evolve(4).isAlive());
    }

    @Test
    public void aDeadCellWith4NeighborsWillStayDeadAfterEvolve(){
        final Cell cell = Cell.DEAD;
        assertFalse(cell.evolve(4).isAlive());
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
            if(neighborCount<=1||neighborCount>3) return Cell.DEAD;
            if(alive==false && neighborCount ==2) return Cell.DEAD;
            return Cell.LIVING;
        }
    }
}
