package controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Scoreboard;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ScoreboardController implements Initializable {

    @FXML private TableView<User> scoreboard;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<User> data = scoreboard.getItems();
        try {
            data.addAll(Scoreboard.getSortedScoreBoard());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void goToPanel(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../panel.fxml"));
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("ChessFX — Panel");
        stage.show();
    }
}
