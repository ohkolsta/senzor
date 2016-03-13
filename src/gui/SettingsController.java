package gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class SettingsController {
	@FXML ColorPicker backgroundColorPicker;
	@FXML ColorPicker alertColorPicker;
	@FXML Slider volumeSlider;
	@FXML Button okButton;
	@FXML Button backButton;


@FXML public void backButton(ActionEvent event) throws IOException{
	Parent viewParent = FXMLLoader.load(getClass().getResource("view.fxml"));
	Scene viewScene = new Scene(viewParent);
	Stage mainStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
	mainStage.setScene(viewScene);
}
}