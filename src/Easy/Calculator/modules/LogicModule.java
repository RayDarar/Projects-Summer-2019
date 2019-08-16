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

    /**
     * After calculating the expression, we should add it to history
     * 
     */
    private static boolean isDelim(char token){
        return token == ' ';
    }
    private static boolean isOperator(char token){
        return token =='+'|| token=='-' || token =='*'|| token=='/';
    }
    private static int getPriority(char operation) {
        switch (operation) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }
    private static void processOperator(LinkedList<Double> numbers,char operation ){
        double num1 = numbers.removeLast();
        double num2 = numbers.removeLast();

        switch (operation) {
            case '+':
                numbers.add(num1+num2);
                break;
            case '-':
                numbers.add(num1-num2);
                break;
            case '*':
                numbers.add(num1*num2);
                break;
            case '/':
                numbers.add(num2/num1);
                break;
        }
    }

    public double calculate(String expression) throws Exception {
        String expr = expression;

        LinkedList<Double> numStack = new LinkedList<Double>();
        LinkedList<Character> operationStack = new LinkedList<Character>();

        for (int i = 0; i <expr.length() ; i++) {
            char token = expr.charAt(i);
            if(isDelim(token)) continue;
            if(token =='(') operationStack.add('(');
            else if(token==')'){
                while(operationStack.getLast()!='(')
                    processOperator(numStack,operationStack.removeLast());
                operationStack.removeLast();
            }else if (isOperator(token)){
                while(!operationStack.isEmpty()&& getPriority(operationStack.getLast())>= getPriority(token))
                    processOperator(numStack,operationStack.removeLast());
                operationStack.add(token);
            }else{
                String operand ="";
                while (i<expr.length()&&Character.isDigit(expr.charAt(i)))
                    operand+= expr.charAt(i++);
                --i;
                numStack.add(Double.parseDouble(operand));
            }
        }
        while (!operationStack.isEmpty())
            processOperator(numStack,operationStack.removeLast());
       return numStack.get(0);

        

        addToHistory(expression, result);
        return numStack.pop();
    }

    private void addToHistory(String expression, double result) {
        history.add(new HistoryItem(expression, result));
    }
}