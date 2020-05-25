package controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.DataManager;
import model.Session;
import model.User;

import java.io.IOException;

public class LoginController {

    @FXML private Label loginMessage;
    @FXML private TextField username;
    @FXML private PasswordField password;

    public void back(MouseEvent mouseEvent) throws IOException {
        SceneHandler.showScene((Stage) ((Node) mouseEvent.getSource()).getScene().getWindow(), SceneHandler.PRIMARY);
    }

    public void login(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        User user = DataManager.getUserByUsername(username.getText());
        if (user == null) {
            loginMessage.setText("Username not exists.");
            // Todo change color to red
            return;
        } else if (!user.getPassword().equals(password.getText())) {
            loginMessage.setText("Wrong password.");
            return;
        }
        Session.getSingletonInstance().setOnlineUser(user);
        SceneHandler.showScene((Stage) ((Node) mouseEvent.getSource()).getScene().getWindow(), SceneHandler.PANEL);
    }
}
