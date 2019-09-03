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

    private static IController data;

    @Override
    public void start(Stage stage) throws Exception {
        data = Fabric.getData();


        stage.show();
	}
    

    public static void execute(String[] args) {
        launch(args);
    }
}