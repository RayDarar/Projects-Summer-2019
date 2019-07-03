package Easy;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Border-radius previewer project
 *
 */

public class BRP extends Application {
    private enum BorderSide {
        all, upperLeft, upperRight, lowerRight, lowerLeft
    }

    /**
     * My back-end method, changeBorder
     *
     * @param element - JavaFX node element, which we're going to change
     * @param side    - Specifies, which side to change
     * @param value   - By what value change element's border
     */
    private void changeBorder(Node element, BorderSide side, int value) {
        String style = element.getStyle();
        if (!style.contains("-fx-border-radius"))
            style += "-fx-border-radius: 0 0 0 0;";

        if (!style.contains("-fx-background-radius"))
            style += "-fx-background-radius: 0 0 0 0;";

        // Getting border
        String border = style.substring(style.indexOf("-fx-border-radius: "));
        String [] borderValues = border.substring(19, border.indexOf(";")).split(" ");
        border = border.substring(0, border.indexOf(";") + 1);

        // Getting background
        String background = style.substring(style.indexOf("-fx-background-radius: "));
        background = background.substring(0, background.indexOf(";") + 1);

        switch (side) {
            case all:
                for (int i = 0; i < 4; borderValues[i] = value + "", i++)
                    ;
                break;
            case lowerLeft:
                borderValues[3] = value + "";
                break;
            case lowerRight:
                borderValues[2] = value + "";
                break;
            case upperLeft:
                borderValues[0] = value + "";
                break;
            case upperRight:
                borderValues[1] = value + "";
                break;
        }

        // Replacing new styles
        style = style.replaceAll(border,
                String.format("-fx-border-radius: %d %d %d %d;", Integer.parseInt(borderValues[0]),
                        Integer.parseInt(borderValues[1]), Integer.parseInt(borderValues[2]),
                        Integer.parseInt(borderValues[3])));
        style = style.replaceAll(background,
                String.format("-fx-background-radius: %d %d %d %d;", Integer.parseInt(borderValues[0]),
                        Integer.parseInt(borderValues[1]), Integer.parseInt(borderValues[2]),
                        Integer.parseInt(borderValues[3])));

        element.setStyle(style);
    }

    /**
     * !!! Rewrite start method Here goes your front-end
     *
     */
    @Override
    public void start(Stage stage) throws Exception {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        //pane.setPadding(new Insets(5,10,10,20));
        pane.setHgap(10);
        pane.setVgap(20);
        pane.setStyle("-fx-background-color : white");

        Button element = new Button();
        element.setMinHeight(100);
        element.setMinWidth(100);
        //element.setStyle("-fx-background-color : violet");

        GridPane.setConstraints(element,2,0);
        GridPane.setColumnSpan(element,3);

        Label upR = new Label("Upper Right");
        Slider upRSlider = new Slider(0,100,0);
        Label upRValue = new Label(Integer.toString((int)upRSlider.getValue()));

        Label upL = new Label("Upper Left");
        Slider upLSlider = new Slider(0,100,0);
        Label upLValue = new Label(Integer.toString((int)upRSlider.getValue()));

        Label lowR = new Label("Lower Right");
        Slider lowRSlider = new Slider(0,100,0);
        Label lowRValue = new Label(Integer.toString((int)upRSlider.getValue()));

        Label lowL = new Label("Lower Right");
        Slider lowLSlider = new Slider(0,100,0);
        Label lowLValue = new Label(Integer.toString((int)upRSlider.getValue()));

        Label all = new Label("All Sides");
        Slider allSlider = new Slider(0,100,0);
        Label allValue = new Label(Integer.toString((int)allSlider.getValue()));

        GridPane.setConstraints(upL,0,1);
        GridPane.setConstraints(upLSlider,1,1);
        GridPane.setConstraints(upLValue,2,1);

        GridPane.setConstraints(upR,3,1);
        GridPane.setConstraints(upRSlider,4,1);
        GridPane.setConstraints(upRValue,5,1);

        GridPane.setConstraints(lowL,0,2);
        GridPane.setConstraints(lowLSlider,1,2);
        GridPane.setConstraints(lowLValue,2,2);

        GridPane.setConstraints(lowR,3,2);
        GridPane.setConstraints(lowRSlider,4,2);
        GridPane.setConstraints(lowRValue,5,2);

        GridPane.setConstraints(all,0,3);
        GridPane.setConstraints(allSlider,1,3);
        GridPane.setConstraints(allValue,2,3);

        upRSlider.valueProperty().addListener((ov,old_val,new_val)->{
            changeBorder(element,BorderSide.upperRight,new_val.intValue());
            upRValue.setText(String.format("%.2f",new_val));
        });
        upLSlider.valueProperty().addListener((ov,old_val,new_val)->{
            changeBorder(element,BorderSide.upperLeft,new_val.intValue());
            upLValue.setText(String.format("%.2f",new_val));
        });
        lowRSlider.valueProperty().addListener((ov,old_val,new_val)->{
            changeBorder(element,BorderSide.lowerRight,new_val.intValue());
            lowRValue.setText(String.format("%.2f",new_val));
        });
        lowLSlider.valueProperty().addListener((ov,old_val,new_val)->{
            changeBorder(element,BorderSide.lowerLeft,new_val.intValue());
            lowLValue.setText(String.format("%.2f",new_val));
        });
        allSlider.valueProperty().addListener((ov,old_val,new_val)->{
            changeBorder(element,BorderSide.all,new_val.intValue());
            allValue.setText(String.format("%.2f",new_val));
        });


        pane.getChildren().addAll(element,upR,upRSlider,upRValue,upL,upLSlider,upLValue,lowR,lowRSlider,lowRValue,lowL,lowLSlider,lowLValue);
        pane.getChildren().addAll(all,allSlider,allValue);

        stage.setScene(new Scene(pane, 550, 400));
        stage.setTitle("Border-radius previewer");
        stage.show();
    }

    public static void execute(String[] args) {
        launch(args);
    }
}

