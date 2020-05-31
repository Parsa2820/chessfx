package model.game.piece;

import model.game.Location;

public class King extends Piece {
    public King(Location currentLocation, boolean lightColor) {
        super(currentLocation, lightColor, KING);
    }

    @Override
    public boolean canMoveTo(Location destination) {
        return Math.abs(destination.getRow()-currentLocation.getRow()) <= 1 &&
                Math.abs(destination.getColumn()-currentLocation.getColumn()) <= 1;
    }
}
