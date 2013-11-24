package de.orchit.conway;


import static junit.framework.TestCase.assertTrue;

public class CellTest {

    public void weHaveLivingCells(){
        assertTrue(new Cell().isAlive());
    }

    private static class Cell {
        public boolean isAlive() {
            return true;
        }
    }
}
