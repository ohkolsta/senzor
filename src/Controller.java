import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.application.*;
import java.util.Timer;
import java.util.TimerTask;
import java.text.DecimalFormat;

public class Controller {

    @FXML
    private Label secondsLabel;
    private GUIService model;
    private boolean running;
    private boolean warning;


    public void initialize(){
        model = new GUIService();
        warning = false;
        startLogging();
    }



    public void startLogging(){
        model.getSpeed();
        model.getDistanceSim();
        running = true;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    if(running) {
                        DecimalFormat format = new DecimalFormat("##.00");
                        double seconds = model.getSeconds();
                        if(seconds<3){
                            warning=true;
                        }
                        else{
                            warning = false;
                        }
                        secondsLabel.setText(String.valueOf(format.format(model.getDistanceSim())+" Sec"));
                        Platform.setImplicitExit(true);

                    }
                    else {
                        timer.cancel();
                        timer.purge();
                    }
                });
            }
        },0, 1000);

    }


    @FXML public void settingsButton(ActionEvent event) throws IOException{
    	Parent settingsParent = FXMLLoader.load(getClass().getResource("fxml/settings.fxml"));
    	Scene settingsScene = new Scene(settingsParent);
    	Stage mainStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
    	mainStage.setScene(settingsScene);
    }


    public void stopPressed(ActionEvent actionEvent) {
        running = false;
    }
}
