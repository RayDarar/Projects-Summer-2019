package Easy.Lights;

import Easy.Lights.interfaces.IController;

import Easy.Lights.Controllers.LightsController;
import Easy.Lights.interfaces.Fabric;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 * Lights
 * 
 * @author Anakharsis9
 */
public class Lights extends Application {

    private static IController controller;
    private static boolean state = true;
    private static LightsController lightsController;

    @Override
    public void start(Stage stage) throws Exception {
        controller = Fabric.getData();

        new Thread() {
            @Override
            public void run() {
                try {
                    while (state) {
                        update(controller.getData());
                        Thread.sleep(300);
                    }
                } catch (Exception e) {
                }
            }
        }.start();

        FXMLLoader stageLoader = new FXMLLoader(Lights.class.getResource("res/lights.fxml"));
        stage.setTitle("Lights");
        stage.setScene(new Scene(stageLoader.load(), 625, 500));

        lightsController = stageLoader.getController();

        stage.show();
    }

    public void update(String[] colors) {
        // Update colors

    }

    public static void execute(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        state = false;
        super.stop();
    }
}