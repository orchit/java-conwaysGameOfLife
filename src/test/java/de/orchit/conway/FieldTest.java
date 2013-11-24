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

    @Test
    public void deadFieldIsAfterEvolveStillDead(){
        Field field = new Field();
        field=field.evolve();
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

        public Field evolve() {
            Field result = new Field();
            for(int x=0;x<result.getField().length;x++){
                Cell[] cells=result.getField()[x];
                for(int y=0;y<cells.length;i++){
                    cells[y]=field[x][y].evolve(0);
                }
            }
            return result;
        }
    }
}
