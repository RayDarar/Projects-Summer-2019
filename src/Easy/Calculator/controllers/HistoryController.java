package Easy.Calculator.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import Easy.Calculator.modules.DataModule;

public class HistoryController {
    private DataModule data = DataModule.getInstance();

    @FXML
    private Button backToCalcBut;

    @FXML
    void toCalc() {
        backToCalcBut.setOnAction(event -> {
            data.showCalculator();
        });
    }
}
