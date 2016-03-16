import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.application.*;
import java.util.Timer;
import java.util.TimerTask;
import java.text.DecimalFormat;

public class Controller {

    public Label kilometerLabel;
    public Label meterLabel;
    public Label secondsLabel;
    public Rectangle card;
    private GUIService model;
    private boolean running;

    public void initialize(){
        model = new GUIService();
        startLogging();
    }



    public void startLogging(){
        running = true;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    if(running) {
                        DecimalFormat format = new DecimalFormat("#0.00");
                        int speed = (int) model.getSpeedInKph();
                        int distance = (int)model.getDistanceSim();
                        double seconds = model.getSeconds();
                        boolean warning = model.displayWarning();
                        if(warning){
                            secondsLabel.setTextFill(Color.web("#ff0000"));
                        }
                        else{
                            secondsLabel.setTextFill(Color.web("#ffffff"));
                        }

                        secondsLabel.setText(String.valueOf(format.format(model.getSeconds())+" sec"));
                        kilometerLabel.setText(String.valueOf(speed)+" km/h");
                        meterLabel.setText(String.valueOf(distance)+" meters");
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

    /*
    @FXML public void settingsButton(ActionEvent event) throws IOException{
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        VBox dialogVbox = new VBox(20);
        dialogVbox.getChildren().add(new Label("Settings"));
        Scene dialogScene = new Scene(dialogVbox, 300, 300);
        dialog.setScene(dialogScene);
        dialog.show();
    }
    */



    public void stopPressed(ActionEvent actionEvent) {
        running = false;
    }
}
