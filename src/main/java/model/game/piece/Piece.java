package model.game.piece;

import javafx.scene.image.Image;
import model.game.Location;

public abstract class Piece {

    public final static char ROOK = 'R';
    public final static char KNIGHT = 'N';
    public final static char BISHOP = 'B';
    public final static char QUEEN = 'Q';
    public final static char KING = 'K';
    public final static char PAWN = 'P';

    protected Location currentLocation;
    protected Image pieceIcon;
    protected boolean lightColor;
    protected char name;

    public Piece(Location currentLocation, boolean lightColor, char name) {
        this.currentLocation = currentLocation;
        this.lightColor = lightColor;
        this.name = name;
        String pathToIcon = "piece/" +
                name +
                (lightColor ? 'w' : 'b') +
                ".png";
        pieceIcon = new Image(pathToIcon);
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Image getPieceIcon() {
        return pieceIcon;
    }

    public boolean isLightColor() {
        return lightColor;
    }

    public abstract boolean canMoveTo(Location destination);

}
