package Easy;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
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
        String borderValue = value + "";
        String style = element.getStyle();
        if (!style.contains("-fx-border-radius"))
            style += "-fx-border-radius: 0 0 0 0;";

        if (!style.contains("-fx-background-radius"))
            style += "-fx-background-radius: 0 0 0 0;";

        // Getting border
        String border = style.substring(style.indexOf("-fx-border-radius: "));
        var borderValues = border.substring(19, border.indexOf(";")).split(" ");
        border = border.substring(0, border.indexOf(";") + 1);

        // Getting background
        String background = style.substring(style.indexOf("-fx-background-radius: "));
        background = background.substring(0, background.indexOf(";") + 1);

        switch (side) {
        case all:
            for (int i = 0; i < 4; borderValues[i] = borderValue, i++)
                ;
            break;
        case lowerLeft:
            borderValues[3] = borderValue;
            break;
        case lowerRight:
            borderValues[2] = borderValue;
            break;
        case upperLeft:
            borderValues[0] = borderValue;
            break;
        case upperRight:
            borderValues[1] = borderValue;
            break;
        }

        // Replacing new styles
        style = style.replaceAll(border, String.format("-fx-border-radius: %s %s %s %s;", borderValues[0],
                borderValues[1], borderValues[2], borderValues[3]));
        style = style.replaceAll(background, String.format("-fx-background-radius: %s %s %s %s;", borderValues[0],
                borderValues[1], borderValues[2], borderValues[3]));

        element.setStyle(style);
    }

    /**
     * !!! Rewrite start method Here goes your front-end
     * 
     */
    @Override
    public void start(Stage stage) throws Exception {
        var root = new Group();

        stage.setScene(new Scene(root, 500, 500));
        stage.setTitle("Border-radius previewer");
        stage.show();
    }

    public static void execute(String[] args) {
        launch(args);
    }
}
