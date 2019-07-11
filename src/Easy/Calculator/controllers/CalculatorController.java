package Easy.Calculator.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import Easy.Calculator.modules.DataModule;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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


    @FXML
    private void processNumpad(ActionEvent event){
        String value = ((Button)event.getSource()).getText();
        mainText.setText(mainText.getText()+value);

        if(mainText.getText().length()>8){
            mainText.setText("ERR");
            mainHistoryText.clear();
            mainHistoryText.setText("ERR");
        }

    }

    @FXML
    private void processOperation(ActionEvent event){
        String mainTextvalue = mainText.getText();
        mainHistoryText.setText(mainHistoryText.getText()+mainTextvalue);
        String value = ((Button)event.getSource()).getText();
        mainHistoryText.setText(mainHistoryText.getText()+value);
        mainText.clear();
    }
    @FXML
    private void clear(){
        mainText.clear();
        mainHistoryText.clear();
    }
    @FXML
    private void back(){
        backBut.setOnAction(event -> {
            String value = mainText.getText();
            mainText.setText(value.substring(0,value.length()-1));

        });
    }

    @FXML
    void toHistory() {
        historyBut.setOnAction(event -> {
            data.showHistory();
        });
    }
}
