package view;

import controller.SceneHandler;
import javafx.application.Application;
import javafx.stage.Stage;

public class GraphicalUserInterface extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        SceneHandler.showScene(stage, SceneHandler.GAME);
    }

    public static void runGui(String[] args) {
        launch(args);
    }
}
