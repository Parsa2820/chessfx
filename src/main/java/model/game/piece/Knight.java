package model.game.piece;

import model.game.Location;

public class Knight extends Piece {

    public Knight(Location currentLocation, boolean lightColor) {
        super(currentLocation, lightColor, KNIGHT);
    }

    @Override
    boolean canMoveTo(Location destination) {
        return false;
    }
}
