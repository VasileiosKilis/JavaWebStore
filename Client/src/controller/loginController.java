package controller;

//import erciyes.AlertHelper;
//import erciyes.client.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import jdk.net.Sockets;
import model.User;
import java.io.IOException;

/**
 * LoginController
 * @author vasileioskilis
 * @version 03/03/2020
 */

public class loginController {

    @FXML private TextField username;
    @FXML private TextField pass;
    @FXML private Button submitButton;

    @FXML
    public void makeLogin(MouseEvent actionEvent) throws Exception {
        Window owner = submitButton.getScene().getWindow();
        User user = new User(username.getText(),pass.getText());
        Client connect = new Client();
        connect.sendMessage("LogIn");
        connect.sendObject(user);

        if(username.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your username");
            return;
        }else if(pass.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your password");
            return;
        }else if(connect.readMessage().equals("Good")){
            try {
                Stage appStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("../pages/home.fxml"));
                appStage.setScene(new Scene(root));
                appStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            Stage appStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("../pages/login.fxml"));
            appStage.setScene(new Scene(root));
            appStage.show();
        }

    }
    @FXML
    public void registrationPage(MouseEvent actionEvent){
        try {
            Stage appStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Parent root=FXMLLoader.load(getClass().getResource("../pages/registration.fxml"));
            appStage.setScene(new Scene(root));
            appStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}