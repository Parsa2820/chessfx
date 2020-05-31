package model.game.piece;

import model.game.Location;

public class Knight extends Piece {

    public Knight(Location currentLocation, boolean lightColor) {
        super(currentLocation, lightColor, KNIGHT);
    }

    @Override
    public boolean canMoveTo(Location destination) {
                return (Math.abs(destination.getRow()-currentLocation.getRow()) == 2 &&
                        Math.abs(destination.getColumn()-currentLocation.getColumn()) == 1) ||
                        (Math.abs(destination.getRow()-currentLocation.getRow()) == 1 &&
                        Math.abs(destination.getColumn()-currentLocation.getColumn()) == 2);
    }
}
