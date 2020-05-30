package model.game.piece;

import model.game.Location;

public class Rook extends Piece {

    public Rook(Location currentLocation, boolean lightColor) {
        super(currentLocation, lightColor, ROOK);
    }

    @Override
    boolean canMoveTo(Location destination) {
        return false;
    }
}
