package Easy.Calculator.modules;

import java.util.Stack;

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



    public double calculate(String expression) {
        String expr = expression;

        String[] numbers = expression.replaceAll("[-/()+*]", " ").split(" ");
        String[] operations = expr.replaceAll("[1234567890]", "").split("");

        Stack<Double> numStack = new Stack<>();
        Stack<String> operationStack = new Stack<>();

        numStack.push(Double.parseDouble(numbers[0]));
        operationStack.push(operations[0]);
        double n;
        int i = 1;

        while (!operationStack.isEmpty()) {
            n = Double.parseDouble(numbers[i]);
            numStack.push(n);
            if (operations.length > 1) {

                if ((getPriority(operations[i]) >= getPriority(operationStack.peek())) ) {
                    operationStack.push(operations[i]);
                }
                if (getPriority(operations[i]) < getPriority(operationStack.peek())) {
                    switch (operationStack.peek()) {
                        case "*":
                            numStack.push(numStack.pop() * numStack.pop());
                            operationStack.pop();
                            break;
                        case "/":
                            numStack.push(numStack.pop() / numStack.pop());
                            operationStack.pop();
                            break;
                    }
                    operationStack.push(operations[i]);
                }
                switch (operationStack.peek()) {
                    case "+":
                        numStack.push(numStack.pop() + numStack.pop());
                        operationStack.pop();
                        break;
                    case "-":
                        numStack.push(numStack.pop() - numStack.pop());
                        operationStack.pop();
                        break;
                }
            }else{
                switch (operationStack.peek()) {
                case "+":
                    numStack.push(numStack.pop() + numStack.pop());
                    operationStack.pop();
                    break;
                case "-":
                    numStack.push(numStack.pop() - numStack.pop());
                    operationStack.pop();
                    break;
                case "*":
                    numStack.push(numStack.pop() * numStack.pop());
                    operationStack.pop();
                    break;
                case "/":
                    numStack.push(numStack.pop() / numStack.pop());
                    operationStack.pop();
                    break;
                    }
                }
            }
            i++;

            return numStack.pop();
        }

    private static int getPriority(String operation){
        switch (operation){
            case "+": return 1;
            case "-": return 1;
            case "/": return 2;
            case "*": return 2;
//            case "(": return 3;
//            case ")": return 3;
        }
        return 0;
    }

}