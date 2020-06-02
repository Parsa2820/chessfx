package view;

import controller.SceneHandler;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Paths;

public class GraphicalUserInterface extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        SceneHandler.showScene(stage, SceneHandler.PRIMARY);
    }
    
    public static void runGui(String[] args) {
        launch(args);
    }
}
