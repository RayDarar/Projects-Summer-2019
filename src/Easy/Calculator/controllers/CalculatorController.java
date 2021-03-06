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
        data.loseFocus(); // Losing focus from buttons if we're clicking
        // Some logic to control font depending on text size
    }

    public void calculate() {
        try {
            String result = logic.calculate(mainText.getText()) + "";

            if (result.substring(result.indexOf(".") + 1).equals("0"))
                result = result.substring(0, result.indexOf("."));

            setText(mainHistoryText, mainText.getText());
            setText(mainText, result + "");
            history.addToHistory(mainHistoryText.getText(), result);
        } catch (Exception e) {
            setText(mainHistoryText, "Error: bad expression");
        }
    }

    public void init(HistoryController history) {
        mainText.setEditable(false);
        mainHistoryText.setEditable(false);
        this.history = history;
    }

    private HistoryController history;

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
