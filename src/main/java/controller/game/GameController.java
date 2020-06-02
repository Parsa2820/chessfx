package controller.game;

import controller.SceneHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.game.Game;
import model.game.Location;
import model.game.piece.Piece;
import model.user.Session;
import model.user.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    public Label turnLabel;
    @FXML private Label messageLabel;
    @FXML private Label rivalsLabel;
    @FXML private ImageView a1;
    @FXML private ImageView a2;
    @FXML private ImageView a3;
    @FXML private ImageView a4;
    @FXML private ImageView a5;
    @FXML private ImageView a6;
    @FXML private ImageView a7;
    @FXML private ImageView a8;
    @FXML private ImageView b1;
    @FXML private ImageView b2;
    @FXML private ImageView b3;
    @FXML private ImageView b4;
    @FXML private ImageView b5;
    @FXML private ImageView b6;
    @FXML private ImageView b7;
    @FXML private ImageView b8;
    @FXML private ImageView c1;
    @FXML private ImageView c2;
    @FXML private ImageView c3;
    @FXML private ImageView c4;
    @FXML private ImageView c5;
    @FXML private ImageView c6;
    @FXML private ImageView c7;
    @FXML private ImageView c8;
    @FXML private ImageView d1;
    @FXML private ImageView d2;
    @FXML private ImageView d3;
    @FXML private ImageView d4;
    @FXML private ImageView d5;
    @FXML private ImageView d6;
    @FXML private ImageView d7;
    @FXML private ImageView d8;
    @FXML private ImageView e1;
    @FXML private ImageView e2;
    @FXML private ImageView e3;
    @FXML private ImageView e4;
    @FXML private ImageView e5;
    @FXML private ImageView e6;
    @FXML private ImageView e7;
    @FXML private ImageView e8;
    @FXML private ImageView f1;
    @FXML private ImageView f2;
    @FXML private ImageView f3;
    @FXML private ImageView f4;
    @FXML private ImageView f5;
    @FXML private ImageView f6;
    @FXML private ImageView f7;
    @FXML private ImageView f8;
    @FXML private ImageView g1;
    @FXML private ImageView g2;
    @FXML private ImageView g3;
    @FXML private ImageView g4;
    @FXML private ImageView g5;
    @FXML private ImageView g6;
    @FXML private ImageView g7;
    @FXML private ImageView g8;
    @FXML private ImageView h1;
    @FXML private ImageView h2;
    @FXML private ImageView h3;
    @FXML private ImageView h4;
    @FXML private ImageView h5;
    @FXML private ImageView h6;
    @FXML private ImageView h7;
    @FXML private ImageView h8;

    private Game game;

    private final ImageView[][] boardImageView = new ImageView[9][9];

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        game = Session.getSingletonInstance().getRunningGame();
        rivalsLabel.setText(game.getWhitePlayer().getUsername() + "(white)" +
                " vs " + game.getBlackPlayer().getUsername() + "(black)");

        boardImageView[1][1] = a1;
        boardImageView[1][2] = b1;
        boardImageView[1][3] = c1;
        boardImageView[1][4] = d1;
        boardImageView[1][5] = e1;
        boardImageView[1][6] = f1;
        boardImageView[1][7] = g1;
        boardImageView[1][8] = h1;
        boardImageView[2][1] = a2;
        boardImageView[2][2] = b2;
        boardImageView[2][3] = c2;
        boardImageView[2][4] = d2;
        boardImageView[2][5] = e2;
        boardImageView[2][6] = f2;
        boardImageView[2][7] = g2;
        boardImageView[2][8] = h2;
        boardImageView[3][1] = a3;
        boardImageView[3][2] = b3;
        boardImageView[3][3] = c3;
        boardImageView[3][4] = d3;
        boardImageView[3][5] = e3;
        boardImageView[3][6] = f3;
        boardImageView[3][7] = g3;
        boardImageView[3][8] = h3;
        boardImageView[4][1] = a4;
        boardImageView[4][2] = b4;
        boardImageView[4][3] = c4;
        boardImageView[4][4] = d4;
        boardImageView[4][5] = e4;
        boardImageView[4][6] = f4;
        boardImageView[4][7] = g4;
        boardImageView[4][8] = h4;
        boardImageView[5][1] = a5;
        boardImageView[5][2] = b5;
        boardImageView[5][3] = c5;
        boardImageView[5][4] = d5;
        boardImageView[5][5] = e5;
        boardImageView[5][6] = f5;
        boardImageView[5][7] = g5;
        boardImageView[5][8] = h5;
        boardImageView[6][1] = a6;
        boardImageView[6][2] = b6;
        boardImageView[6][3] = c6;
        boardImageView[6][4] = d6;
        boardImageView[6][5] = e6;
        boardImageView[6][6] = f6;
        boardImageView[6][7] = g6;
        boardImageView[6][8] = h6;
        boardImageView[7][1] = a7;
        boardImageView[7][2] = b7;
        boardImageView[7][3] = c7;
        boardImageView[7][4] = d7;
        boardImageView[7][5] = e7;
        boardImageView[7][6] = f7;
        boardImageView[7][7] = g7;
        boardImageView[7][8] = h7;
        boardImageView[8][1] = a8;
        boardImageView[8][2] = b8;
        boardImageView[8][3] = c8;
        boardImageView[8][4] = d8;
        boardImageView[8][5] = e8;
        boardImageView[8][6] = f8;
        boardImageView[8][7] = g8;
        boardImageView[8][8] = h8;

        updateBoard();
    }

    private void updateBoard() {
        Piece[][] board = game.getBoard();

        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                if (board[i][j] != null) {
                    boardImageView[i][j].setImage(board[i][j].getPieceIcon());
                } else {
                    boardImageView[i][j].setImage(null);
                }
            }
        }
    }

    public void selectMove(MouseEvent mouseEvent) {
        ImageView src = (ImageView) mouseEvent.getSource();

        Piece selected = game.getSelectedPiece();
        Location preLocation = null;
        if (selected != null) {
            preLocation = selected.getCurrentLocation();
        }
        Location location = new Location(src.getId());

        switch (game.selectMove(location)) {

            case SELECTED:
                messageLabel.setText(src.getId() + " selected");
                break;
            case MOVED:
                assert selected != null;
                boardImageView[location.getRow()][location.getColumn()].setImage(selected.getPieceIcon());
                boardImageView[preLocation.getRow()][preLocation.getColumn()].setImage(null);
                messageLabel.setText("Moved");
                break;
            case CAN_NOT_SELECT:
                messageLabel.setText("Can not select this square");
                break;
            case CAN_NOT_MOVE:
                messageLabel.setText("Can not move to this square");
                break;
            case ALREADY_MOVED:
                messageLabel.setText("You already moved");
        }
    }

    public void onUndoClick() {
        if (game.undo()) {
           messageLabel.setText("Undo done");
           updateBoard();
        } else {
            messageLabel.setText("You have no undo left");
        }
    }

    public void onNextTurnClick(MouseEvent mouseEvent) throws IOException {

        switch (game.nextTurn()) {

            case NO_MOVE_DONE:
                messageLabel.setText("Move then click next turn button");
                break;
            case MOVE_DONE:
                turnLabel.setText("It is " + ( game.isLightColorTurn() ? "white" : "black" ) + " turn");
                break;
            case DRAW:
                Alert drawAlert = new Alert(Alert.AlertType.INFORMATION, "Draw", ButtonType.OK);
                drawAlert.setResizable(true);
                drawAlert.showAndWait();
                SceneHandler.showScene((Stage) ((Node) mouseEvent.getSource()).getScene().getWindow(), SceneHandler.PANEL);
                break;
            case FINISHED_WITH_WINNER:
                User winner = game.isLightColorTurn() ? game.getBlackPlayer() : game.getWhitePlayer();
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "The winner is " + winner.getUsername(), ButtonType.OK);
                alert.setResizable(true);
                alert.showAndWait();
                SceneHandler.showScene((Stage) ((Node) mouseEvent.getSource()).getScene().getWindow(), SceneHandler.PANEL);
                break;
        }
        updateBoard();
    }

    public void onForfeitClick(MouseEvent mouseEvent) throws IOException {
        game.forfeit();
        User winner = game.isLightColorTurn() ? game.getBlackPlayer() : game.getWhitePlayer();
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "The winner is " + winner.getUsername() +
                " (with opponent forfeit)", ButtonType.OK);
        alert.setResizable(true);
        alert.showAndWait();
        SceneHandler.showScene((Stage) ((Node) mouseEvent.getSource()).getScene().getWindow(), SceneHandler.PANEL);
    }
}
