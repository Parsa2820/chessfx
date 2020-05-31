package model.game.piece;

import model.game.Location;
import model.user.Session;

public class Queen extends Piece {

    public Queen(Location currentLocation, boolean lightColor) {
        super(currentLocation, lightColor, QUEEN);
    }

    @Override
    public boolean canMoveTo(Location destination) {
        return canBishopMoveTo(destination) || canRookMoveTo(destination);
    }

    public boolean canRookMoveTo(Location destination) {
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

    public boolean canBishopMoveTo(Location destination) {
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
