package controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Product;
import model.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




public class homeController {

    @FXML private Button recommendationPage;

    @FXML
    public void loginPage(MouseEvent actionEvent){

        try {
            Stage appStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Parent root=FXMLLoader.load(getClass().getResource("login.fxml"));
            appStage.setScene(new Scene(root));
            appStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void registrationPage(MouseEvent actionEvent){
        try {
            Stage appStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Parent root=FXMLLoader.load(getClass().getResource("registration.fxml"));
            appStage.setScene(new Scene(root));
            appStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void sellPage(MouseEvent actionEvent){
        try {
            Stage appStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Parent root=FXMLLoader.load(getClass().getResource("sellPage.fxml"));
            appStage.setScene(new Scene(root));
            appStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void ReccomendationPage (MouseEvent actionEvent){
        try {
            Stage appStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Parent root=FXMLLoader.load(getClass().getResource("buyPage.fxml"));
            appStage.setScene(new Scene(root));
            appStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
