import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainGUI extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml/view.fxml"));
        primaryStage.setTitle("Senzor");
        primaryStage.setScene(new Scene(root));
        primaryStage.setWidth(550);
        primaryStage.setHeight(500);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }



}
