package controller.panel;

import controller.SceneHandler;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.user.Scoreboard;
import model.user.User;
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
        } catch (IOException | ClassNotFoundException ioException) {
            ioException.printStackTrace();
        }
    }


    public void back(MouseEvent mouseEvent) throws IOException {
        SceneHandler.showScene((Stage) ((Node) mouseEvent.getSource()).getScene().getWindow(), SceneHandler.PANEL);
    }
}
