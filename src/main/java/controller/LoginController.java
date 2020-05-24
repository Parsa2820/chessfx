package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    public void goToPrimaryMenu(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../primary.fxml"));
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("ChessFX");
        stage.show();
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
        Parent root = FXMLLoader.load(getClass().getResource("../panel.fxml"));
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("ChessFX — Panel");
        stage.show();
    }
}
