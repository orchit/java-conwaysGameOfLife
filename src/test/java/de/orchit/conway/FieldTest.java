package de.orchit.conway;

import org.junit.Test;

public class FieldTest {
    @Test
    public void weCanInitAFieldThatConsistsOfDeadCells(){

        Cell [][] field = new Cell[10][15];
        for (Cell[] cells : field) {
            for(int i=0;i<cells.length;i++){
                cells[i]=Cell.DEAD;
            }
        }
    }
}
