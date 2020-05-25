package model;

import java.util.ArrayList;

public class Game {
    User whitePlayer;
    User blackPlayer;
    int whiteUndoLeft;
    int blackUndoLeft;
    int turnLimit;
    ArrayList<Move> moves;

    public Game(User whitePlayer, User blackPlayer, int undoMove, int turnLimit) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        whiteUndoLeft = undoMove;
        blackUndoLeft = undoMove;
        this.turnLimit = turnLimit;
        moves = new ArrayList<>();
    }

}

class Move {

}
