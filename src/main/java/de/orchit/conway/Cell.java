package de.orchit.conway;

class Cell {
    public static Cell LIVING = new Cell(true);
    public static Cell DEAD = new Cell(false);

    private boolean alive;

    Cell(boolean isAlive) {
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
