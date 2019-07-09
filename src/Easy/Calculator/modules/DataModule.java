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

    public void loadStages(Stage parentStage) {
        if (!stagesLoaded) {
            calculator = parentStage;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Calculator.class.getResource("res/history.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            history = new Stage();
            history.setScene(new Scene(root));
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