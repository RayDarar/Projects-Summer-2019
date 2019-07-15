package Easy.Calculator.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import Easy.Calculator.modules.DataModule;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class CalculatorController {
    private DataModule data = DataModule.getInstance();

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

    public void setText(TextField target, String value) {
        target.setText(target.getText() + value);

        if (target.getText().length() > 8)
            mainHistoryText.setText("ERR");
    }

    @FXML
    private void processNumpad(ActionEvent event) {
        setText(mainText, ((Button) event.getSource()).getText());
    }

    @FXML
    private void processOperation(ActionEvent event) {
        setText(mainHistoryText, mainHistoryText.getText() + mainText.getText());
        setText(mainHistoryText, mainHistoryText.getText() + ((Button) event.getSource()).getText());
        mainText.clear();
    }

    @FXML
    private void clear(ActionEvent event) {
        mainText.clear();
        mainHistoryText.clear();
    }

    @FXML
    private void back(ActionEvent event) {
        String value = mainText.getText();
        setText(mainText, value.substring(0, value.length() - 1));
    }

    @FXML
    void toHistory(ActionEvent event) {
        data.showHistory();
    }
}
