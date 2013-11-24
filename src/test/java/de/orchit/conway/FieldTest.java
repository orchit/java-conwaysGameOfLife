package de.orchit.conway;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class FieldTest {

    @Test
    public void weCanInitAFieldThatConsistsOfDeadCells(){
        final Field field = new Field(10, 15);
        for (Cell[] cells : field.getField()) {
            for(int i=0;i<cells.length;i++){
                assertFalse(cells[i].isAlive());
            }
        }
    }

    @Test
    public void deadFieldIsAfterEvolveStillDead(){
        Field field = new Field(10, 15);
        field=field.evolve();
        for (Cell[] cells : field.getField()) {
            for(int i=0;i<cells.length;i++){
                assertFalse(cells[i].isAlive());
            }
        }
    }

    private static class Field{
        private final int width;
        private final int height;
        private Cell [][] field;

        private Field(int width, int height) {
            this.width = width;
            this.height = height;
            this.field = new Cell[this.width][this.height];
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
            Field result = new Field(width, height);
            for(int x=0;x<result.getField().length;x++){
                Cell[] cells=result.getField()[x];
                for(int y=0;y<cells.length;y++){
                    cells[y]=field[x][y].evolve(0);
                }
            }
            return result;
        }
    }
}
