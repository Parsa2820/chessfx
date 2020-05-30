package model.game.piece;

import model.game.Location;

public class Bishop extends Piece {

    public Bishop(Location currentLocation, boolean lightColor) {
        super(currentLocation, lightColor, BISHOP);
    }

    @Override
    boolean canMoveTo(Location destination) {
        return false;
    }
}
