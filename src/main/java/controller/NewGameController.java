package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.DataManager;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewGameController implements Initializable {

    @FXML private Label newGameMessage;
    @FXML private TextField turnLimitTextField;
    @FXML private TextField undoMoveTextField;
    @FXML private TextField opponentUsername;

    public void goToPanel(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../panel.fxml"));
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("ChessFX — Panel");
        stage.show();
    }


    public void startGame(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        int turnLimit = Integer.parseInt(turnLimitTextField.getText());
        int undoMove = Integer.parseInt(undoMoveTextField.getText());
        User opponent = DataManager.getUserByUsername(opponentUsername.getText());
        if (opponent == null) {
            newGameMessage.setText("Wrong opponent username");
            return;
        }
        // Todo start game
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Todo validate text fields for numerical input
    }
}
