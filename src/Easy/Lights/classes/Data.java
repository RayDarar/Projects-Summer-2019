package Easy.Lights.classes;

import Easy.Lights.interfaces.IData;

/**
 * Data
 * @author RayDarar
 */

public class Data implements IData {

    @Override
    public String[] getData() {
        return new String[] { "#000000", "#000000", "#000000", "#000000", "#000000", "#000000", "#000000", };
    }
}