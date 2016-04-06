import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class TabController implements Initializable {
    @FXML Controller viewController;
    @FXML SettingsController settingsController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        viewController.attachMain(this);
        settingsController.attachMain(this);

    }

    public void colorUpdate(Color newValue) {
        viewController.changeColor(newValue);
    }

    public void sliderUpdate(int newValue) {
        viewController.changeWarningTime(newValue);
    }

    public void backgroundColorUpdate(Color newValue) {
        viewController.changeBackgroundColor(newValue);
    }
}
