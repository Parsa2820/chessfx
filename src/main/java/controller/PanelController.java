package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Session;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PanelController implements Initializable {

    @FXML private Label greetMessage;

    public void onLogoutClick(MouseEvent mouseEvent) throws IOException {
        Session.getSingletonInstance().setOnlineUser(null);
        Parent root = FXMLLoader.load(getClass().getResource("../primary.fxml"));
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("ChessFX");
        stage.show();
    }

    public void onScoreboardClick(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../scoreboard.fxml"));
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("ChessFX — Scoreboard");
        stage.show();
    }

    public void onNewGameButtonClick(MouseEvent mouseEvent) {
    }

    public void greet() {
        greetMessage.setText("Welcome dear " + Session.getSingletonInstance().getOnlineUser().getUsername());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        greet();
    }
}
