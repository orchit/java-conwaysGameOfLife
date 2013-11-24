package de.orchit.conway;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class FieldTest {

    @Test
    public void weCanInitAFieldThatConsistsOfDeadCells(){
        final Field field = new Field();
        for (Cell[] cells : field.getField()) {
            for(int i=0;i<cells.length;i++){
                assertFalse(cells[i].isAlive());
            }
        }
    }

    private static class Field{
        private Cell [][] field;

        private Field() {
            this.field = new Cell[10][15];
            for (Cell[] cells : field) {
                for(int i=0;i<cells.length;i++){
                    cells[i]=Cell.DEAD;
                }
            }
        }

        private Cell[][] getField() {
            return field;
        }
    }
}
