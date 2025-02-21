import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

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

    public static double evaluate(String expression) {
        return calculate(expression);
    }

    public static double calculate(String expression) {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        Pattern pattern = Pattern.compile("([-+*/^()])|(\\d+(\\.\\d+)?)");
        Matcher matcher = pattern.matcher(expression);

        while (matcher.find()) {
            if (matcher.group(1) != null) {
                String operator = matcher.group(1);
                switch (operator) {
                    case "(":
                        operators.push('(');
                        break;
                    case ")":
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
                        while (!operators.isEmpty() && precedence(operator.charAt(0)) <= precedence(operators.peek())) {
                            numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
                        }
                        operators.push(operator.charAt(0));
                        break;
                }
            } else if (matcher.group(2) != null) {
                numbers.push(Double.parseDouble(matcher.group(2)));
            }
        }

        while (!operators.isEmpty()) {
            numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
        }

        return numbers.pop();
    }

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
