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
import javafx.scene.paint.Paint;
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
    private TabController main;
    private Color warningColor;

    public void initialize(){
        model = new GUIService();
        startLogging();
        warningColor = Color.web("#ff0000");

    }



    public void startLogging(){
        running = true;
        new Thread(new Runnable(){
        	public void run(){
        		while(true){
        			Platform.runLater(() -> {
                        if(running) {
                            DecimalFormat format = new DecimalFormat("#0.00");
                            int speed = (int) model.getSpeedInKph();
                            int distance = (int)model.getDistanceSim();
                            double seconds = model.getSeconds();
                            boolean warning = model.displayWarning();
                            if(warning){
                                secondsLabel.setTextFill(warningColor);
                            }
                            else{
                                secondsLabel.setTextFill(Color.web("#ffffff"));
                            }

                            secondsLabel.setText(String.valueOf(format.format(model.getSeconds())+" sec"));
                            kilometerLabel.setText(String.valueOf(speed)+" km/h");
                            meterLabel.setText(String.valueOf(distance)+" meters");
                            Platform.setImplicitExit(true);

                        }
        			});
        			try{
        				Thread.sleep(1000);
        			} catch(Exception e){
        				//ignored
        			}
        			if(!running){
        				break;
        			}
        			
        		}
        	}
        	
        }).start();
    }



    
    @FXML public void settingsButton(ActionEvent event) throws IOException{
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        VBox dialogVbox = new VBox(20);
        dialogVbox.getChildren().add(new Label("Settings"));
        Scene dialogScene = new Scene(dialogVbox, 300, 300);
        dialog.setScene(dialogScene);
        dialog.show();
    }
    


    public void stopPressed(ActionEvent actionEvent) {
        running = false;
    }

    public void attachMain(TabController tabController) {
        this.main=tabController;
    }

    public void changeColor(Color newValue) {
        warningColor = newValue;

    }

    public void changeWarningTime(int newValue) {
        model.setWarningTime(newValue);
    }

    public void changeBackgroundColor(Color newValue) {
        card.setFill(newValue);
    }
}
