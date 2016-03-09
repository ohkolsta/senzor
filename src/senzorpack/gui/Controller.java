package gui;
import javafx.fxml.*;
import javafx.scene.control.Label;

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


}
