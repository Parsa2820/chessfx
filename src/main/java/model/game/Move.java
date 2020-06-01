package model.game;

import model.game.piece.Piece;

public class Move {
    Piece piece;
    Location start;
    Location end;
    Piece killed;

    public Move(Piece piece, Location start, Location end, Piece killed) {
        this.piece = piece;
        this.start = start;
        this.end = end;
        this.killed = killed;
    }

    public Move(Piece piece, Location start, Location end) {
        this.piece = piece;
        this.start = start;
        this.end = end;
        killed = null;
    }
}
