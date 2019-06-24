package Easy;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
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
        System.out.println("Current style: " + element.getStyle());
        switch (side) {
        case all:
            break;
        case lowerLeft:
            break;
        case lowerRight:
            break;
        case upperLeft:
            break;
        case upperRight:
            break;
        }
    }

    /**
     * !!! Rewrite start method Here goes your front-end
     * 
     */
    @Override
    public void start(Stage stage) throws Exception {
        var root = new Group();

        Button button = new Button("Button");
        button.setPadding(new Insets(30));
        button.setLayoutX(100);
        button.setLayoutY(100);
        button.setStyle("-fx-border-style: solid inside; -fx-border-radius: 10;");

        Slider slider = new Slider();
        slider.valueProperty().addListener((ChangeListener<Number>) (arg0, oldValue, newValue) -> {
            changeBorder(button, BorderSide.all, newValue.intValue());
        });

        root.getChildren().addAll(slider, button);

        stage.setScene(new Scene(root, 500, 500));
        stage.setTitle("Border-radius previewer");
        stage.show();
    }

    public static void execute(String[] args) {
        launch(args);
    }
}