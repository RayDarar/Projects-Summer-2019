package Easy.Lights.interfaces;

import Easy.Lights.classes.Controller;

/**
 * IFabric
 * @author RayDarar
 */

public class Fabric {
    public static IController getData() {
        return new Controller();
    }
}