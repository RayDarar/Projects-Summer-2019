package app;

import static javafx.scene.layout.VBox.setMargin;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private TextField bin = new TextField();
    private TextField dec = new TextField();
    private Button toDec = new Button("===>");
    private Button toBin = new Button("<===");
    static int pow = 0, decres = 0;
    static String binRes = "";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label cmLabel = new Label("Binary", bin);
        cmLabel.setContentDisplay(ContentDisplay.LEFT);
        Label inchesLabel = new Label("Decimal", dec);
        inchesLabel.setContentDisplay(ContentDisplay.LEFT);

        VBox vBox = new VBox();

        HBox hBox1 = new HBox();

        VBox vBox1 = new VBox();

        vBox1.getChildren().addAll(toBin, toDec);
        hBox1.getChildren().addAll(cmLabel, vBox1, inchesLabel);
        vBox.getChildren().add(hBox1);
        hBox1.setSpacing(10);
        hBox1.setAlignment(Pos.CENTER_LEFT);

        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);
        setMargin(hBox1, new Insets(0, 0, 0, 10));

        toBin.setOnAction(e -> {
            int num = Integer.parseInt(dec.getText());
            bin.setText(convertToBin(num));
        });
        toDec.setOnAction(e -> {

            dec.setText(String.valueOf(convertToDecInbuilt(bin.getText())));
        });

        Scene scene = new Scene(vBox, 500, 200);
        primaryStage.setTitle("Convert");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static int convertToDec(int temp) {
        while (temp != 0) {
            int rem = temp % 10;
            decres = (int) (decres + (rem * Math.pow(2, pow)));
            pow++;
            temp /= 10;
        }
        return decres;
    }

    public static int convertToDecInbuilt(String bin) {
        return Integer.parseInt(bin, 2);
    }

    public static String convertToBin(int num) {
        return binRes + Integer.toBinaryString(num);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
