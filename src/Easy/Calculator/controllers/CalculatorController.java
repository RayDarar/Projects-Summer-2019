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

    public boolean numberWaiting = true;
    public boolean operatorWaiting = false;

    public void add(String value) {

    }

    public void init() {
        mainText.setEditable(false);
        mainHistoryText.setEditable(false);
    }

    @FXML
    private void processNumpad(ActionEvent event) {

    }

    @FXML
    private void processOperation(ActionEvent event) {

    }

    @FXML
    private void clear(ActionEvent event) {

    }

    @FXML
    private void back(ActionEvent event) {

    }

    @FXML
    void toHistory(ActionEvent event) {
        data.showHistory();
    }
}
