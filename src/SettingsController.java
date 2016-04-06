import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SettingsController implements Initializable{

	public ColorPicker colorPicker;
	public Slider distanceSlider;
	public ColorPicker backgroundColorPicker;
	private TabController main;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		colorPicker.setValue(Color.web("#ff0000"));
		backgroundColorPicker.setValue(Color.web("#f0ad4f"));
		distanceSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
			main.sliderUpdate(newValue.intValue());
		});

		colorPicker.valueProperty().addListener((observable, oldValue, newValue)->{
			main.colorUpdate(newValue);
		});

		backgroundColorPicker.valueProperty().addListener((observable, oldValue, newValue)->{
			main.backgroundColorUpdate(newValue);
		});

	}

	public void attachMain(TabController tabController) {
		this.main=tabController;
	}

}