package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GraphicalUserInterface extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent primary = FXMLLoader.load(getClass().getResource("../primary.fxml"));
        stage.setScene(new Scene(primary));
        stage.setTitle("ChessFX");
        stage.show();
    }
}
