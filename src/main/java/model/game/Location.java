package model.game;

public class Location {

    private int column;
    private int row;

    public Location(int row, int column) {
        this.column = column;
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
