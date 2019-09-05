package Easy.Lights;

import Easy.Lights.interfaces.IController;

import Easy.Lights.Controllers.LightsController;
import Easy.Lights.interfaces.Fabric;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Lights
 * 
 * @author Anakharsis9
 */
public class Lights extends Application {

    public static IController controller;
    public static boolean state = true;
    private static LightsController lightsController;

    @Override
    public void start(Stage stage) throws Exception {
        controller = Fabric.getData();

        new Thread() {
            @Override
            public void run() {
                try {
                    while (state) {
                        if (controller.getState())
                            update(controller.getData());
                        Thread.sleep(100);
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
        lightsController.light_1.setFill(Color.web(colors[0]));
        lightsController.light_2.setFill(Color.web(colors[1]));
        lightsController.light_3.setFill(Color.web(colors[2]));
        lightsController.light_4.setFill(Color.web(colors[3]));
        lightsController.light_5.setFill(Color.web(colors[4]));
        lightsController.light_6.setFill(Color.web(colors[5]));
        lightsController.light_7.setFill(Color.web(colors[6]));
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