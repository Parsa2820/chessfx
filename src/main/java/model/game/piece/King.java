package model.game.piece;

import model.game.Location;

public class King extends Piece {
    public King(Location currentLocation, boolean lightColor) {
        super(currentLocation, lightColor, KING);
    }

    @Override
    boolean canMoveTo(Location destination) {
        return false;
    }
}
