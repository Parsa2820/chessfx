package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SceneHandler {

    public static final RawScene PRIMARY = new RawScene() {
        @Override
        public String getFileName() {
            return "../primary.fxml";
        }

        @Override
        public String getWindowTitle() {
            return "ChessFX";
        }
    };

    public static final RawScene LOGIN = new RawScene() {
        @Override
        public String getFileName() {
            return "../login.fxml";
        }

        @Override
        public String getWindowTitle() {
            return "ChessFX — Login";
        }
    };

    public static final RawScene SIGN_UP = new RawScene() {
        @Override
        public String getFileName() {
            return "../signup.fxml";
        }

        @Override
        public String getWindowTitle() {
            return "ChessFX — SignUp";
        }
    };

    public static final RawScene DELETE_USER = new RawScene() {
        @Override
        public String getFileName() {
            return "../delete.fxml";
        }

        @Override
        public String getWindowTitle() {
            return "ChessFX — Delete user";
        }
    };

    public static final RawScene CHANGE_PASSWORD = new RawScene() {
        @Override
        public String getFileName() {
            return "../change.fxml";
        }

        @Override
        public String getWindowTitle() {
            return "ChessFX — Change password";
        }
    };

    public static final RawScene PANEL = new RawScene() {
        @Override
        public String getFileName() {
            return "../panel.fxml";
        }

        @Override
        public String getWindowTitle() {
            return "ChessFX — Panel";
        }
    };

    public static final RawScene NEW_GAME = new RawScene() {
        @Override
        public String getFileName() {
            return "../new.fxml";
        }

        @Override
        public String getWindowTitle() {
            return "ChessFX — New game";
        }
    };

    public static final RawScene SCOREBOARD = new RawScene() {
        @Override
        public String getFileName() {
            return "../scoreboard.fxml";
        }

        @Override
        public String getWindowTitle() {
            return "ChessFX — Scoreboard";
        }
    };

    public static final RawScene GAME = new RawScene() {
        @Override
        public String getFileName() {
            return "../game.fxml";
        }

        @Override
        public String getWindowTitle() {
            return "ChessFX — Game";
        }
    };

    public static void showScene(Stage stage, RawScene rawScene) throws IOException {
        Parent root = FXMLLoader.load(SceneHandler.class.getResource(rawScene.getFileName()));
        stage.setScene(new Scene(root));
        stage.setTitle(rawScene.getWindowTitle());
        stage.show();
    }
}

abstract class RawScene {
    public abstract String getFileName();
    public abstract String getWindowTitle();
}
