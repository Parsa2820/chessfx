package model.game.piece;

import model.game.Location;
import model.user.Session;

public class Rook extends Piece {

    public Rook(Location currentLocation, boolean lightColor) {
        super(currentLocation, lightColor, ROOK);
    }

    @Override
    public boolean canMoveTo(Location destination) {
        Piece[][] board = Session.getSingletonInstance().getRunningGame().getBoard();
        int smallerNum, num;
        if (destination.getRow() != currentLocation.getRow() && destination.getColumn() != currentLocation.getColumn()) {
            return false;
        } else if (currentLocation.getRow() == destination.getRow()) {
            smallerNum = Math.min(currentLocation.getColumn(), destination.getColumn());
            num = destination.getColumn() + currentLocation.getColumn() - smallerNum;
            for (++smallerNum; smallerNum < num; smallerNum++) {
                if (board[currentLocation.getRow()][smallerNum] != null) {
                    return false;
                }
            }
        } else {
            smallerNum = Math.min(currentLocation.getRow(), destination.getRow());
            num = destination.getRow() + currentLocation.getRow() - smallerNum;
            for (++smallerNum; smallerNum < num; smallerNum++) {
                if (board[smallerNum][currentLocation.getColumn()] != null) {
                    return false;
                }
            }
        }
        return true;
    }
}
