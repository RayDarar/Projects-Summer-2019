package Easy.Calculator;

import Easy.Calculator.modules.DataModule;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
        Parent root = FXMLLoader.load(Calculator.class.getResource("res/calculator.fxml"));
        stage.setTitle("Calculator");
        stage.setScene(new Scene(root, 240, 305));
        stage.show();

        

        data.loadStages(stage); // Parent stage is actually a calculator
    }
}