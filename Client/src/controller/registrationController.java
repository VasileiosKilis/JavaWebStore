package controller;

//import erciyes.client.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;

import java.io.IOException;

public class registrationController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField address;

    @FXML
    private Button submitButton;

    @FXML
    protected void submitButton(ActionEvent actionEvent) {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String phone = usernameField.getText();
        String address1 = address.getText();



        User user = new User(nameField.getText(),emailField.getText(),passwordField.getText(),usernameField.getText(),address.getText());
        Client connect = new Client();
        connect.sendMessage("Register");
        connect.sendObject(user);
        try {
            Stage appStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Parent root=FXMLLoader.load(getClass().getResource("../pages/home.fxml"));
            appStage.setScene(new Scene(root));
            appStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
