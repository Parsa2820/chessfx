package model.game.piece;

import model.game.Location;
import model.user.Session;

public class Bishop extends Piece {

    public Bishop(Location currentLocation, boolean lightColor) {
        super(currentLocation, lightColor, BISHOP);
    }

    @Override
    public boolean canMoveTo(Location destination) {
        Piece[][] board = Session.getSingletonInstance().getRunningGame().getBoard();
        int xEnd = destination.getRow();
        int xStart = currentLocation.getRow();
        int yEnd = destination.getColumn();
        int yStart = currentLocation.getColumn();
        int xIncrement;
        boolean xState;
        int yIncrement;
        if (Math.abs(xEnd-xStart) != Math.abs(yEnd-yStart)) {
            return false;
        }
        if (xEnd-xStart > 0) {
            xIncrement = 1;
            --xEnd;
            ++xStart;
            xState = true;
        } else {
            xIncrement = -1;
            ++xEnd;
            --xStart;
            xState = false;
        }
        if (yEnd-yStart > 0) {
            yIncrement = 1;
            --yEnd;
            ++yStart;
        } else {
            yIncrement = -1;
            ++yEnd;
            --yStart;
        }
        boolean ifClauseX;
        if (xState) {
            ifClauseX = (xStart <= xEnd);
        } else {
            ifClauseX = (xStart >= xEnd);
        }
        while (ifClauseX) {
            if (board[xStart][yStart] != null) {
                return false;
            }
            xStart += xIncrement;
            yStart += yIncrement;
            if (xState) {
                ifClauseX = (xStart <= xEnd);
            } else {
                ifClauseX = (xStart >= xEnd);
            }
        }
        return true;
    }
}
