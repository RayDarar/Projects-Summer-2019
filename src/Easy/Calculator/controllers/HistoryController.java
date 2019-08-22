package Easy.Calculator.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import Easy.Calculator.modules.DataModule;

public class HistoryController {
    private DataModule data = DataModule.getInstance();

    @FXML
    private Button backToCalcBut;

    @FXML
    private TextArea list;

    @FXML
    void toCalc(ActionEvent event) {
        data.showCalculator();
    }

    public void addToHistory(String expression, String result) {
        String text = list.getText() + expression + " = " + result + "\n";
        list.setText(text);
    }
}
