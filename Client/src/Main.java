import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("pages/login.fxml"));
        primaryStage.setTitle("Web Shop");
        primaryStage.setScene(new Scene(root, 960, 600));
        primaryStage.show();
        System.out.println("start");
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
