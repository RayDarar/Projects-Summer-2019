package Easy.Lights.interfaces;

import Easy.Lights.classes.Data;

/**
 * IFabric
 * @author RayDarar
 */

public class Fabric {
    public static IData getData() {
        return new Data();
    }
}