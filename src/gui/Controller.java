package gui;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Controller {

    @FXML
    Label label;
    int counter = 0;
    public void initialize(){
        System.out.println("hello");

    }

    @FXML
    public void buttonPressed(){
        counter++;
        label.setText(counter+"");
    }
    
    @FXML public void settingsButton(ActionEvent event) throws IOException{
    	Parent settingsParent = FXMLLoader.load(getClass().getResource("settings.fxml"));
    	Scene settingsScene = new Scene(settingsParent);
    	Stage mainStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
    	mainStage.setScene(settingsScene);
    }


}
