package Easy.Calculator.modules;

/**
 * LogicModule
 * 
 */

public class LogicModule {
    private static LogicModule logic;

    private LogicModule() {
    }

    public static LogicModule getInstance() {
        if (logic == null)
            logic = new LogicModule();

        return logic;
    }
}