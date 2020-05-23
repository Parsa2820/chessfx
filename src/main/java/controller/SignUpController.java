package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.DataManager;
import model.User;

import java.io.IOException;

public class SignUpController {

    @FXML private Label signUpMessage;
    @FXML private TextField username;
    @FXML private PasswordField password;

    public void goToPrimaryMenu(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../primary.fxml"));
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void signUp(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        DataManager.addUser(new User(username.getText(), password.getText()));
        signUpMessage.setText("successfully");
    }
}
