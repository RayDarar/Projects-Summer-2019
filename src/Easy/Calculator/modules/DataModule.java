package Easy.Calculator.modules;

import java.util.ArrayList;

import Easy.Calculator.Calculator;
import Easy.Calculator.controllers.CalculatorController;
import Easy.Calculator.controllers.HistoryController;
import javafx.fxml.FXMLLoader;
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

            calculator.getScene().addEventHandler(KeyEvent.KEY_TYPED, key -> { // Operators/digits
                Character value = key.getCharacter().charAt(0);
                ArrayList<Character> inputs = new ArrayList<>();
                inputs.add('+');
                inputs.add('-');
                inputs.add('*');
                inputs.add('/');
                if (Character.isDigit(value) || value.equals('(') || value.equals(')'))
                    calculatorController.processNumpad(value + "");
                else if (inputs.contains(value))
                    calculatorController.processOperation(value + "");
            });
            calculator.getScene().addEventHandler(KeyEvent.KEY_PRESSED, key -> { // Special keys, like you :3
                switch (key.getCode()) {
                case BACK_SPACE:
                    calculatorController.back();
                    break;
                case C:
                    calculatorController.clear();
                    break;
                case H:
                    calculatorController.toHistory(null);
                    break;
                case ENTER:
                    calculatorController.calculate();
                    break;
                default:
                    break;
                }
            });

            FXMLLoader historyLoader = new FXMLLoader(Calculator.class.getResource("res/history.fxml"));
            history = new Stage();
            history.setTitle("History");
            history.setScene(new Scene(historyLoader.load(), 240, 305));
            HistoryController HistoryController = historyLoader.getController();
            calculatorController.init(HistoryController);

            stagesLoaded = true;
        }
    }

    public void loseFocus() {
        calculator.getScene().getRoot().requestFocus();
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