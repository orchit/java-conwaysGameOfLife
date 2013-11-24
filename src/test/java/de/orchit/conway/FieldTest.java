package de.orchit.conway;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class FieldTest {

    @Test
    public void weCanInitAFieldThatConsistsOfDeadCells() {
        final Field field = new Field(10, 15);
        for (Cell[] cells : field.getField()) {
            for (int i = 0; i < cells.length; i++) {
                assertFalse(cells[i].isAlive());
            }
        }
    }

    @Test
    public void deadFieldIsAfterEvolveStillDead() {
        Field field = new Field(10, 15);
        field = field.evolve();
        for (Cell[] cells : field.getField()) {
            for (int i = 0; i < cells.length; i++) {
                assertFalse(cells[i].isAlive());
            }
        }
    }

    @Test
    public void fieldWith3LivingCellsInALineHas2MoreLivingCellsAfterwards() {
        Field field = new Field(10, 15);
        field.getField()[3][4] = Cell.LIVING;
        field.getField()[3][5] = Cell.LIVING;
        field.getField()[3][6] = Cell.LIVING;
        field = field.evolve();
        int[][] expectedLivingCells = {{3, 4}, {3, 5}, {3, 6}, {2, 5}, {4, 5}};
        for (int x = 0; x < field.getField().length; x++) {
            Cell[] cells = field.getField()[x];
            for (int y = 0; y < cells.length; y++) {
                assertEquals(contains(expectedLivingCells, x, y), cells[y].isAlive());
            }
        }
    }

    private boolean contains(int[][] expectedLivingCells, int x, int y) {
        for (int[] coords : expectedLivingCells) {
            if (coords[0] == x && coords[1] == y) return true;
        }
        return false;
    }

}
