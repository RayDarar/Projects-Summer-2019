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
    public ToggleButton start_Button = new ToggleButton();

    @FXML
    public ToggleButton stop_Button = new ToggleButton();

    @FXML
    public Ellipse light_1 = new Ellipse();

    @FXML
    public Ellipse light_2 = new Ellipse();

    @FXML
    public Ellipse light_3 = new Ellipse();

    @FXML
    public Ellipse light_4 = new Ellipse();

    @FXML
    public Ellipse light_5 = new Ellipse();

    @FXML
    public Ellipse light_6 = new Ellipse();

    @FXML
    public Ellipse light_7 = new Ellipse();

    @FXML
    public Slider slider = new Slider(100, 100, 1000);

    @FXML
    public Label value = new Label();

    @FXML
    private void setColor(ActionEvent event) {
        Lights.controller.on();
    }

    @FXML
    private void stop(ActionEvent ev) {
        Lights.controller.off();

    }
}