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

public class DeleteUserController {

    @FXML private Label deleteMessage;
    @FXML private TextField username;
    @FXML private PasswordField password;

    public void goToPrimaryMenu(MouseEvent mouseEvent) throws IOException {
SceneHandler.showScene((Stage) ((Node) mouseEvent.getSource()).getScene().getWindow(), SceneHandler.PRIMARY);
    }

    public void deleteUser(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        User user = DataManager.getUserByUsername(username.getText());
        if (user == null) {
            deleteMessage.setText("Username not exists.");
            // Todo change color to red
            return;
        } else if (!user.getPassword().equals(password.getText())) {
            deleteMessage.setText("Wrong password.");
            return;
        }
        DataManager.deleteUser(username.getText());
        Alert userDeletedSuccessfully = new Alert(Alert.AlertType.INFORMATION, "User successfully deleted",
                ButtonType.OK);
        userDeletedSuccessfully.showAndWait();
        goToPrimaryMenu(mouseEvent);
    }
}
