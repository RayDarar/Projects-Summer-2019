package Easy.Lights.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;


public class LightsController {

    @FXML
    public Button startButton = new Button() ;

    @FXML
    public Button stopButton = new Button() ;

    @FXML
    public Ellipse light_1 = new Ellipse();

    @FXML
    public Ellipse light_2 = new Ellipse() ;

    @FXML
    public Ellipse light_3 = new Ellipse() ;

    @FXML
    public Ellipse light_4 = new Ellipse();

    @FXML
    public Ellipse light_5 = new Ellipse() ;

    @FXML
    public Ellipse light_6 = new Ellipse() ;

    @FXML
    public Ellipse light_7 = new Ellipse() ;

    private void setColor(){
        light_1.setFill(Color.RED);
    }
}