package Easy.Lights.classes;

import java.util.Random;

import Easy.Lights.interfaces.IController;

/**
 * Data
 * 
 * @author RayDarar
 */

public class Controller implements IController {
    private boolean state;
    private Thread task;
    private long time;
    private String[][] colors = 
    { 
            { "#FF0000", "#CC0000", "#660000", "#CC0000", "#FF0000" }, // red
            { "#FF7B00", "#CC6300", "#663100", "#CC6300", "#FF7B00" }, // orange
            { "#FFE900", "#CCBB00", "#665E00", "#CCBB00", "#FFE900" }, // yellow
            { "#49FF01", "#3ACC00", "#1D6600", "#3ACC00", "#49FF01" }, // green
            { "#01FFD4", "#00CCAA", "#006655", "#00CCAA", "#01FFD4" }, // light blue
            { "#0116FF", "#0011CC", "#000866", "#0011CC", "#0116FF" }, // blue
            { "#EB00FF", "#BB00CC", "#5D0066", "#BB00CC", "#EB00FF" }, // Violet
    };
    private final int n_of_colors = 7;
    private final int n_of_color_states = 5;
    private int[] indexes = new int[n_of_colors];

    public Controller() {
        state = false;
        time = 300;
        
        // Beginning state
        Random rnd = new Random();
        for (int i = 0; i < n_of_colors; i++)
            indexes[i] = rnd.nextInt(n_of_color_states);

        task = new Thread() {
            @Override
            public void run() {
                try {
                    while (state) {
                        update();
                        Thread.sleep(time);
                    }
                } catch (Exception e) {
                }
            }
        };

        task.start();
    }

    /**
     * Updates all colors
     * 
     */
    private void update() {
        for (int i = 0; i < n_of_colors; i++) {
            indexes[i]++;
            if (indexes[i] < n_of_color_states)
                continue;

            indexes[i] = 0;
        }
    }

    @Override
    public String[] getData() {
        String[] result = new String[n_of_colors];

        for (int i = 0; i < n_of_colors; i++)
            result[i] = colors[i][indexes[i]];

        return result;
    }

    @Override
    public void on() {
        state = true;
    }

    @Override
    public void off() {
        state = false;
    }
}