package Easy.Calculator;

import Easy.Calculator.modules.DataModule;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Calculator
 * 
 * A simple calculator, without eval-kind functions
 */

public class Calculator extends Application {
    private DataModule data = DataModule.getInstance();

    public static void execute(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage stage) throws Exception {
        data.loadStages(stage);
        data.showCalculator();
    }
}