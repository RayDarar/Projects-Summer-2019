package Easy.Calculator.modules;

import java.util.LinkedList;

/**
 * LogicModule
 * 
 */

public class LogicModule {
    // Singleton items
    private static LogicModule logic;

    private LogicModule() {
        history = new LinkedList<>();
    }

    public static LogicModule getInstance() {
        if (logic == null)
            logic = new LogicModule();

        return logic;
    }

    // History items
    private class HistoryItem {
        String expression;
        double result;

        HistoryItem(String e, double r) {
            expression = e;
            result = r;
        }
    }

    private LinkedList<HistoryItem> history;

    // Other logic
    public double calculate(String expression) {
        return 0;
    }

    private void addToHistory(String expression, double result) {
        history.add(new HistoryItem(expression, result));
    }
}