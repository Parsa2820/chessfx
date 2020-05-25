package controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.DataManager;
import model.User;

import java.io.IOException;

public class SignUpController {

    @FXML private Label signUpMessage;
    @FXML private TextField username;
    @FXML private PasswordField password;

    public void back(MouseEvent mouseEvent) throws IOException {
        SceneHandler.showScene((Stage) ((Node) mouseEvent.getSource()).getScene().getWindow(), SceneHandler.PRIMARY);
    }

    public void signUp(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        if (DataManager.getUserByUsername(username.getText()) != null) {
            signUpMessage.setText("This username is taken. Please try another username.");
            // Todo change color to red
            return;
        }
        DataManager.addUser(new User(username.getText(), password.getText()));
        Alert signedUpSuccessfully = new Alert(Alert.AlertType.INFORMATION, "User successfully created",
                ButtonType.OK);
        signedUpSuccessfully.showAndWait();
        SceneHandler.showScene((Stage) ((Node) mouseEvent.getSource()).getScene().getWindow(), SceneHandler.PRIMARY);
    }
}
