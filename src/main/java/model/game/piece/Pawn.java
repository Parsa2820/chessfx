package model.game.piece;

import model.game.Location;
import model.user.Session;

public class Pawn extends Piece {

    public Pawn(Location currentLocation, boolean lightColor) {
        super(currentLocation, lightColor, PAWN);
    }

    @Override
    public boolean canMoveTo(Location destination) {
        Piece[][] board = Session.getSingletonInstance().getRunningGame().getBoard();
        if (lightColor) {
            if (currentLocation.getRow() == 2 && destination.getRow() == 4 &&
                    destination.getColumn() == currentLocation.getColumn()) {
                return board[3][destination.getColumn()] == null && board[4][destination.getColumn()] == null;
            } if (destination.getColumn() == currentLocation.getColumn() &&
                    destination.getRow()-currentLocation.getRow() == 1 &&
                    board[destination.getRow()][destination.getColumn()] == null) {
                return true;
            }
            return destination.getRow() - currentLocation.getRow() == 1 &&
                    Math.abs(destination.getColumn() - currentLocation.getColumn()) == 1 &&
                    board[destination.getRow()][destination.getColumn()] != null;
        } else {
            if (currentLocation.getRow() == 7 &&
                    destination.getRow() == 5 &&
                    destination.getColumn() == currentLocation.getColumn()) {
                return board[6][destination.getColumn()] == null &&
                        board[5][destination.getColumn()] == null;
            }
            if (destination.getColumn() == currentLocation.getColumn() &&
                    currentLocation.getRow()-destination.getRow() == 1 &&
                    board[destination.getRow()][destination.getColumn()] == null) {
                return true;
            }
            return currentLocation.getRow() - destination.getRow() == 1 &&
                    Math.abs(destination.getColumn() - currentLocation.getColumn()) == 1 &&
                    board[destination.getRow()][destination.getColumn()] != null;
        }
    }
}
