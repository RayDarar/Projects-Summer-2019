package Easy.Lights.Controllers;

import Easy.Lights.Lights;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.shape.Ellipse;

public class LightsController {

    @FXML
    public ToggleButton start_Button;

    @FXML
    public ToggleButton stop_Button;

    @FXML
    public Ellipse light_1;

    @FXML
    public Ellipse light_2;

    @FXML
    public Ellipse light_3;

    @FXML
    public Ellipse light_4;

    @FXML
    public Ellipse light_5;

    @FXML
    public Ellipse light_6;

    @FXML
    public Ellipse light_7;

    @FXML
    public Slider slider;

    @FXML
    public Label value = new Label();

    @FXML
    private void setColor(ActionEvent event) {
        Lights.controller.on();
        slider.setDisable(true);
    }

    @FXML
    private void stop(ActionEvent ev) {
        Lights.controller.off();
        slider.setDisable(false);
    }
}