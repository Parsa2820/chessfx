package model.game;

public class Location {

    private int column;
    private int row;

    public Location(int row, int column) {
        this.column = column;
        this.row = row;
    }

    public Location(String alphaNum) {
        row = 9 - alphaNum.charAt(1) - 48;
        column = (int) alphaNum.charAt(0) - 96;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
