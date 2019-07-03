package Easy.Calculator;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Calculator
 * 
 * A simple calculator, without eval-kind functions
 */

public class Calculator extends Application {
    public static void execute(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        stage.setTitle("Calculator");
        stage.show();
    }
}