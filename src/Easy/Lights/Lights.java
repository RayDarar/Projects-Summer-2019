package Easy.Lights;

import Easy.Lights.interfaces.IController;
import Easy.Lights.interfaces.Fabric;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Lights
 * @author Anakharsis9
 */
public class Lights extends Application {

    private static IController controller;

    @Override
    public void start(Stage stage) throws Exception {
        controller = Fabric.getData();

        new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        update(controller.getData());
                        Thread.sleep(300);
                    }
                } catch (Exception e) {
                }
            }
        };

        stage.show();
	}
    
    public void update(String[] colors) {
        // Update colors
    }

    public static void execute(String[] args) {
        launch(args);
    }
}