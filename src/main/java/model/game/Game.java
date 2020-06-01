package model.game;

import controller.SceneHandler;
import model.DataManager;
import model.game.piece.*;
import model.user.User;

import java.util.ArrayList;

public class Game {
    private User whitePlayer;
    private User blackPlayer;
    private int whiteUndoLeft;
    private int blackUndoLeft;
    private int turnLimit;
    private Move stagedMove;
    private ArrayList<Move> moves;
    private Piece[][] board = new Piece[9][9];
    private Piece selectedPiece;

    public Game(User whitePlayer, User blackPlayer, int undoMove, int turnLimit) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        whiteUndoLeft = undoMove;
        blackUndoLeft = undoMove;
        this.turnLimit = turnLimit;
        moves = new ArrayList<>();
        initializeBoard();
    }

    public Piece getSelectedPiece() {
        return selectedPiece;
    }

    public void setSelectedPiece(Piece selectedPiece) {
        this.selectedPiece = selectedPiece;
    }

    private void initializeBoard() {

        for (int i = 1; i <= 8; i++) {
            board[7][i] = new Pawn(new Location(7, i), false);
            board[2][i] = new Pawn(new Location(2, i), true);
        }

        board[8][1] = new Rook(new Location(8, 1), false);
        board[8][2] = new Knight(new Location(8, 2), false);
        board[8][3] = new Bishop(new Location(8, 3), false);
        board[8][4] = new Queen(new Location(8, 4), false);
        board[8][5] = new King(new Location(8, 5), false);
        board[8][6] = new Bishop(new Location(8, 6), false);
        board[8][7] = new Knight(new Location(8, 7), false);
        board[8][8] = new Rook(new Location(8, 8), false);

        board[1][1] = new Rook(new Location(1, 1), true);
        board[1][2] = new Knight(new Location(1, 2), true);
        board[1][3] = new Bishop(new Location(1, 3), true);
        board[1][4] = new Queen(new Location(1, 4), true);
        board[1][5] = new King(new Location(1, 5), true);
        board[1][6] = new Bishop(new Location(1, 6), true);
        board[1][7] = new Knight(new Location(1, 7), true);
        board[1][8] = new Rook(new Location(1, 1), true);
    }

    public User getWhitePlayer() {
        return whitePlayer;
    }

    public void setWhitePlayer(User whitePlayer) {
        this.whitePlayer = whitePlayer;
    }

    public User getBlackPlayer() {
        return blackPlayer;
    }

    public void setBlackPlayer(User blackPlayer) {
        this.blackPlayer = blackPlayer;
    }

    public int getWhiteUndoLeft() {
        return whiteUndoLeft;
    }

    public void setWhiteUndoLeft(int whiteUndoLeft) {
        this.whiteUndoLeft = whiteUndoLeft;
    }

    public int getBlackUndoLeft() {
        return blackUndoLeft;
    }

    public void setBlackUndoLeft(int blackUndoLeft) {
        this.blackUndoLeft = blackUndoLeft;
    }

    public int getTurnLimit() {
        return turnLimit;
    }

    public void setTurnLimit(int turnLimit) {
        this.turnLimit = turnLimit;
    }

    public ArrayList<Move> getMoves() {
        return moves;
    }

    public void setMoves(ArrayList<Move> moves) {
        this.moves = moves;
    }

    public Piece[][] getBoard() {
        return board;
    }

    public SelectMoveType selectMove(Location location) {
        if (board[location.getRow()][location.getColumn()] == null ||
                board[location.getRow()][location.getColumn()].isLightColor() != isLightColorTurn()) {
            if (selectedPiece != null) {
                if (selectedPiece.canMoveTo(location)) {
                    if (stagedMove == null){
                        move(location);
                        return SelectMoveType.MOVED;
                    } else {
                        return SelectMoveType.ALREADY_MOVED;
                    }
                } else {
                    return SelectMoveType.CAN_NOT_MOVE;
                }
            } else {
                return SelectMoveType.CAN_NOT_SELECT;
            }
        } else {
            selectedPiece = board[location.getRow()][location.getColumn()];
            return SelectMoveType.SELECTED;
        }
    }

    private void move(Location location) {
        stagedMove = new Move(selectedPiece, selectedPiece.getCurrentLocation(),
                location, board[location.getRow()][location.getColumn()]);
        board[location.getRow()][location.getColumn()] = selectedPiece;
        board[selectedPiece.getCurrentLocation().getRow()][selectedPiece.getCurrentLocation().getColumn()] = null;
        selectedPiece.setCurrentLocation(location);
        selectedPiece = null;
    }

    public boolean undo() {
        if (stagedMove != null && (isLightColorTurn() && whiteUndoLeft-- > 0) || (!isLightColorTurn() && blackUndoLeft-- > 0)) {
            board[stagedMove.start.getRow()][stagedMove.start.getColumn()] = stagedMove.piece;
            board[stagedMove.end.getRow()][stagedMove.end.getColumn()] = stagedMove.killed;
            stagedMove.piece.setCurrentLocation(stagedMove.start);
            selectedPiece = null;
            stagedMove = null;
            return true;
        }
        return false;
    }

    public boolean nextTurn() {
        if (stagedMove != null) {
            moves.add(stagedMove);
            stagedMove = null;
            selectedPiece = null;
            return true;
        }
        return false;
    }

    public boolean isLightColorTurn() {
        return moves.size() % 2 == 0;
    }

    public void forfeit() {
        if (isLightColorTurn()) {
            whitePlayer.addResignLose();
            blackPlayer.addResignWin();
        } else {
            whitePlayer.addResignWin();
            blackPlayer.addResignLose();
        }
        updateUsers();
    }

    private void updateUsers() {
        try {
            DataManager.deleteUser(blackPlayer.getUsername());
            DataManager.deleteUser(whitePlayer.getUsername());
            DataManager.addUser(whitePlayer);
            DataManager.addUser(blackPlayer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
