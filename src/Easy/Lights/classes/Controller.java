package Easy.Lights.classes;

import Easy.Lights.interfaces.IController;

/**
 * Data
 * @author RayDarar
 */

public class Controller implements IController {

    public Controller() {

    }

    @Override
    public String[] getData() {
        return new String[] { "#000000", "#000000", "#000000", "#000000", "#000000", "#000000", "#000000", };
    }

    @Override
    public void on() {

    }

    @Override
    public void off() {

    }
}