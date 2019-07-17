package Easy.Calculator.modules;

import java.io.IOException;
import java.util.ArrayList;

import Easy.Calculator.Calculator;
import Easy.Calculator.controllers.CalculatorController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * DataModule
 * 
 */

public class DataModule {
    private static DataModule data;

    private DataModule() {
    }

    public static DataModule getInstance() {
        if (data == null)
            data = new DataModule();
        return data;
    }

    private boolean stagesLoaded = false;
    private Stage calculator; // Also a parent stage
    private Stage history;

    public void loadStages(Stage parentStage) throws Exception {
        if (!stagesLoaded) {
            FXMLLoader calculatorLoader = new FXMLLoader(Calculator.class.getResource("res/calculator.fxml"));
            calculator = parentStage;
            calculator.setTitle("Calculator");
            calculator.setScene(new Scene(calculatorLoader.load(), 240, 305));
            CalculatorController calculatorController = calculatorLoader.getController();
            calculatorController.init();

            calculator.getScene().addEventHandler(KeyEvent.KEY_PRESSED, key -> {
                char value = key.getText().charAt(0);
                ArrayList<Character> operators = new ArrayList<>();
                operators.add('+');
                operators.add('-');
                operators.add('*');
                operators.add('/');
                if (Character.isDigit(value) || operators.contains(value)) {

                }
            });

            history = new Stage();
            history.setScene(new Scene(FXMLLoader.load(Calculator.class.getResource("res/history.fxml")), 240, 305));
            history.setTitle("History");
            stagesLoaded = true;
        }
    }

    public void showCalculator() {
        if (stagesLoaded) {
            history.hide();
            calculator.show();
        }
    }

    public void showHistory() {
        if (stagesLoaded) {
            calculator.hide();
            history.show();
        }
    }
}