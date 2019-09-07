package Easy.Lights.interfaces;

/**
 * IData
 * 
 */

public interface IController {
    public String[] getData(); // 7

    public void on();

    public void off();

    public boolean getState();

    public void setTime(long time);

    public long getTime();
}