/**
 * Calculator class to evaluate mathematical expressions.
 */
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    /**
     * Main method to take user input and display the result.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter expression (e.g., 1 + 1):");
        String expression = scanner.nextLine();

        try {
            double result = evaluate(expression);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Evaluates the given mathematical expression.
     * @param expression The expression to evaluate.
     * @return The result of the evaluation.
     */
    public static double evaluate(String expression) {
        return calculate(expression);
    }

    /**
     * Calculates the result of the expression using stacks for numbers and operators.
     * @param expression The mathematical expression to calculate.
     * @return The calculated result.
     */
    public static double calculate(String expression) {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        // Regular expression to match operators and numbers
        Pattern pattern = Pattern.compile("([-+*/^()])|(\\d+(\\.\\d+)?)");
        Matcher matcher = pattern.matcher(expression);

        // Iterate through the expression to parse numbers and operators
        while (matcher.find()) {
            if (matcher.group(1) != null) {
                String operator = matcher.group(1);
                switch (operator) {
                    case "(":
                        operators.push('(');
                        break;
                    case ")":
                        // Evaluate the expression inside the parentheses
                        while (!operators.isEmpty() && operators.peek() != '(') {
                            numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
                        }
                        operators.pop(); // Remove '('
                        break;
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                    case "^":
                        // Apply operators based on precedence
                        while (!operators.isEmpty() && precedence(operator.charAt(0)) <= precedence(operators.peek())) {
                            numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
                        }
                        operators.push(operator.charAt(0));
                        break;
                }
            } else if (matcher.group(2) != null) {
                // Push the number onto the numbers stack
                numbers.push(Double.parseDouble(matcher.group(2)));
            }
        }

        // Apply remaining operators
        while (!operators.isEmpty()) {
            numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
        }

        return numbers.pop();
    }

    /**
     * Determines the precedence of an operator.
     * @param operator The operator to check.
     * @return The precedence value.
     */
    static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }

    /**
     * Applies the operator to the operands.
     * @param operator The operator to apply.
     * @param b The second operand.
     * @param a The first operand.
     * @return The result of the operation.
     * @throws IllegalArgumentException if the operator is invalid.
     */
    static double applyOperator(char operator, double b, double a) {
        switch (operator) {
            case '+':
                return Addition.add(a, b);
            case '-':
                return Subtraction.subtract(a, b);
            case '*':
                return Multiplication.multiply(a, b);
            case '/':
                return Division.divide(a, b);
            case '^':
                return Exponentiation.exponentiate(a, b);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
