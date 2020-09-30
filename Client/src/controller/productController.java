package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class productController {

    @FXML
    public void loginPage(MouseEvent actionEvent){

        try {
            Stage appStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Parent root= FXMLLoader.load(getClass().getResource("../login.fxml"));
            appStage.setScene(new Scene(root));
            appStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
