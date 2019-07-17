package Easy.Calculator.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import Easy.Calculator.modules.DataModule;
import Easy.Calculator.modules.LogicModule;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class CalculatorController {
    private DataModule data = DataModule.getInstance();
    private LogicModule logic = LogicModule.getInstance();

    @FXML
    private Button historyBut;

    @FXML
    private Button backBut;

    @FXML
    private Button clearBut;

    @FXML
    private ImageView backLogo;

    @FXML
    private TextField mainText;

    @FXML
    private TextField mainHistoryText;

    private void setText(TextField target, String text) {
        target.setText(text);
        // Some logic to control font depending on text size
    }

    public void calculate() {
        try {
            double result = logic.calculate(mainText.getText());
            setText(mainHistoryText, mainText.getText());
            setText(mainText, result + "");
        } catch (Exception e) {
            setText(mainHistoryText, "Error: bad expression");
        }
    }

    public void init() {
        mainText.setEditable(false);
        mainHistoryText.setEditable(false);
    }

    public void processNumpad(String value) {
        setText(mainText, mainText.getText() + value);
        wasOperator = false;
    }

    @FXML
    private void processNumpad(ActionEvent event) {
        processNumpad(((Button) event.getSource()).getText());
    }

    private boolean wasOperator = false;

    public void processOperation(String value) {
        if (!wasOperator) {
            setText(mainText, mainText.getText() + value);
            wasOperator = true;
        }
    }

    @FXML
    private void processOperation(ActionEvent event) {
        processOperation(((Button) event.getSource()).getText());
    }

    public void clear() {
        setText(mainText, "");
        setText(mainHistoryText, "");
    }

    @FXML
    private void clear(ActionEvent event) {
        clear();
    }

    public void back() {
        setText(mainText, mainText.getText().substring(0, mainText.getText().length() - 1));
    }

    @FXML
    private void back(ActionEvent event) {
        if (mainText.getText().length() != 0)
            back();
    }

    @FXML
    public void toHistory(ActionEvent event) {
        data.showHistory();
    }
}
