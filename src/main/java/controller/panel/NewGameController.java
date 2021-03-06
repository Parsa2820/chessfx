package controller.panel;

import controller.SceneHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.DataManager;
import model.game.Game;
import model.user.Session;
import model.user.User;

import java.io.IOException;

public class NewGameController {

    @FXML private Label newGameMessage;
    @FXML private TextField turnLimitTextField;
    @FXML private TextField undoMoveTextField;
    @FXML private TextField opponentUsername;

    public void goToPanel(MouseEvent mouseEvent) throws IOException {
        SceneHandler.showScene((Stage) ((Node) mouseEvent.getSource()).getScene().getWindow(), SceneHandler.PANEL);
    }


    public void startGame(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        int turnLimit = Integer.parseInt(turnLimitTextField.getText());
        int undoMove = Integer.parseInt(undoMoveTextField.getText());
        User opponent = DataManager.getUserByUsername(opponentUsername.getText());
        if (opponent == null) {
            newGameMessage.setText("Wrong opponent username");
            return;
        }
        if (Session.getSingletonInstance().getOnlineUser().getUsername().equals(opponent.getUsername())) {
            newGameMessage.setText("You can not play with yourself :|");
            return;
        }
        Game game = new Game(Session.getSingletonInstance().getOnlineUser(), opponent, undoMove, turnLimit);
        Session.getSingletonInstance().setRunningGame(game);

        SceneHandler.showScene((Stage) ((Node) mouseEvent.getSource()).getScene().getWindow(), SceneHandler.GAME);
    }
}
