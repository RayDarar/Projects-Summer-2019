package Easy.Calculator.modules;

import java.io.IOException;

import Easy.Calculator.Calculator;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
            calculator = parentStage;
            calculator.setTitle("Calculator");
            calculator.setScene(
                    new Scene(FXMLLoader.load(Calculator.class.getResource("res/calculator.fxml")), 240, 305));

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