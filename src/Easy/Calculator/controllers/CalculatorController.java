package Easy.Calculator.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import Easy.Calculator.modules.DataModule;

public class CalculatorController {
    private DataModule data = DataModule.getInstance();

    @FXML
    private Button historyBut;

    @FXML
    void toHistory(ActionEvent event) {
        data.showHistory();
    }
}
