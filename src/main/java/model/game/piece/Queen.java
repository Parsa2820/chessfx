package model.game.piece;

import model.game.Location;

public class Queen extends Piece {

    public Queen(Location currentLocation, boolean lightColor) {
        super(currentLocation, lightColor, QUEEN);
    }

    @Override
    boolean canMoveTo(Location destination) {
        return false;
    }
}
