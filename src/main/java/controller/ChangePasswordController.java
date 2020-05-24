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
import model.User;

import java.io.IOException;

public class ChangePasswordController {

    @FXML private Label changePasswordMessage;
    @FXML private TextField username;
    @FXML private PasswordField oldPassword;
    @FXML private PasswordField newPassword;

    public void goToPrimaryMenu(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../primary.fxml"));
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("ChessFX");
        stage.show();
    }

    public void changePassword(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        User user = DataManager.getUserByUsername(username.getText());
        if (user == null) {
            changePasswordMessage.setText("Username not exists.");
            // Todo change color to red
            return;
        } else if (!user.getPassword().equals(oldPassword.getText())) {
            changePasswordMessage.setText("Wrong password.");
            return;
        }
        User newUser = new User(user);
        DataManager.deleteUser(username.getText());
        newUser.setPassword(newPassword.getText());
        DataManager.addUser(newUser);
        Alert passwordSuccessfullyChanged = new Alert(Alert.AlertType.INFORMATION, "Password successfully changed",
                ButtonType.OK);
        passwordSuccessfullyChanged.showAndWait();
        goToPrimaryMenu(mouseEvent);
    }
}
