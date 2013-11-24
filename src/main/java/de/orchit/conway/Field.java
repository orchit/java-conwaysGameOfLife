package de.orchit.conway;


class Field {
    private final int width;
    private final int height;
    private Cell[][] field;

    Field(int width, int height) {
        this.width = width;
        this.height = height;
        this.field = new Cell[this.width][this.height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < field[x].length; y++) {
                field[x][y] = Cell.DEAD;
            }
        }
    }

    public Cell[][] getField() {
        return field;
    }

    public Field evolve() {
        Field result = new Field(width, height);
        for (int x = 0; x < result.getField().length; x++) {
            Cell[] cells = result.getField()[x];
            for (int y = 0; y < cells.length; y++) {
                cells[y] = field[x][y].evolve(getNeighborCount(x,y));
            }
        }
        return result;
    }

    private int getNeighborCount(int x, int y) {
        int result = 0;
        result += getCell(x-1, y+1).isAlive()?1:0;
        result += getCell(x+0, y+1).isAlive()?1:0;
        result += getCell(x+1, y+1).isAlive()?1:0;
        result += getCell(x-1, y+0).isAlive()?1:0;
        result += getCell(x+0, y+0).isAlive()?1:0;
        result += getCell(x+1, y+0).isAlive()?1:0;
        result += getCell(x-1, y-1).isAlive()?1:0;
        result += getCell(x+0, y-1).isAlive()?1:0;
        result += getCell(x+1, y-1).isAlive()?1:0;
        return result;
    }

    private Cell getCell(int x, int y) {
        if(x<0||y<0 ||x>=field.length || y>=field[0].length)
            return Cell.DEAD;
        return field[x][y];
    }
}
