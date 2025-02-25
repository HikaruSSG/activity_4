/**
 * Division class to perform division operation.
 */
public class Division {
    /**
     * Divides two numbers.
     * @param a The first number.
     * @param b The second number.
     * @return The result of the division.
     * @throws ArithmeticException if dividing by zero.
     */
    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}
