package Lab10;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyLIFO_App {

    public static <E> void reserve(E[] array) {
        Stack<E> stack = new Stack<>();
        for (E e : array) {
            stack.push(e);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
        System.out.println(Arrays.toString(array));
    }

    // This method checks the correctness of the given input

    // i.e. ()(())[]{(())} ==> true, ){[]}() ==> false
    public static boolean isCorrect(String input) {
        Stack<Character> stack = new Stack<>();
        input = input.trim();
        for (char c : input.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    // This method evaluates the value of an expression
    // i.e. 51 + (54 *(3+2)) = 321
    public static int evaluateExpression(String expression) {
        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        String formattedExpression = formatExpression(expression);

        String[] tokens = formattedExpression.split(" ");

        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            } else if (Character.isDigit(token.charAt(0))) {
                operandStack.push(Integer.parseInt(token));
            } else if (token.equals("+") || token.equals("-")) {
                processOperators(operandStack, operatorStack, '+', '-');
                operatorStack.push(token.charAt(0));
            } else if (token.equals("*") || token.equals("/")) {
                processOperators(operandStack, operatorStack, '*', '/');
                operatorStack.push(token.charAt(0));
            } else if (token.equals("(")) {
                operatorStack.push('(');
            } else if (token.equals(")")) {
                processClosingBracket(operandStack, operatorStack);
            }
        }

        while (!operatorStack.isEmpty()) {
            performOperation(operandStack, operatorStack);
        }

        return operandStack.pop();
    }

    private static String formatExpression(String expression) {
        StringBuilder formatted = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (c == '(' || c == ')' || c == '+' || c == '-' || c == '*' || c == '/') {
                formatted.append(" ").append(c).append(" ");
            } else {
                formatted.append(c);
            }
        }
        return formatted.toString();
    }

    private static void processOperators(Stack<Integer> operandStack, Stack<Character> operatorStack, char op1, char op2) {
        while (!operatorStack.isEmpty() && (operatorStack.peek() == op1 || operatorStack.peek() == op2)) {
            performOperation(operandStack, operatorStack);
        }
    }

    private static void performOperation(Stack<Integer> operandStack, Stack<Character> operatorStack) {
        int operand2 = operandStack.pop();
        int operand1 = operandStack.pop();
        char operator = operatorStack.pop();
        int result = 0;
        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                result = operand1 / operand2;
                break;
        }
        operandStack.push(result);
    }

    private static void processClosingBracket(Stack<Integer> operandStack, Stack<Character> operatorStack) {
        while (operatorStack.peek() != '(') {
            performOperation(operandStack, operatorStack);
        }
        operatorStack.pop(); // Remove '('
    }


    public static <E> void stutter(Queue<E> input) {
        Queue<E> queue = new LinkedList<E>();
        int size = input.size();
        for (int i = 0; i < size; i++) {
            E e = input.poll();
            queue.offer(e);
            queue.offer(e);
        }
        System.out.println(queue);
    }

    // Method mirror that accepts a queue of strings as a parameter and appends the
    // queue's contents to itself in reverse order
    // front [a, b, c] back
    // becomes
    // front [a, b, c, c, b, a] back
    public static <E> void mirror(Queue<E> input) {
        Stack<E> stack = new Stack<>();
        int size = input.size();
        for (int i = 0; i < size; i++) {
            E e = input.poll();
            stack.push(e);
            input.offer(e);

        }
        for (int i = 0; i < size; i++) {
            input.offer(stack.pop());
        }
        System.out.println(input);
    }

}
