# Calculator Project

This project is a simple calculator implemented in Java. It supports basic arithmetic operations such as addition, subtraction, multiplication, division, and exponentiation.

## Files

- `Calculator.java`: Main class that provides the user interface and handles user input.
- `Addition.java`: Class that performs addition operation.
- `Subtraction.java`: Class that performs subtraction operation.
- `Multiplication.java`: Class that performs multiplication operation.
- `Division.java`: Class that performs division operation.
- `Exponentiation.java`: Class that performs exponentiation operation.

## Usage

To use the calculator, compile all the Java files using the following command:

```bash
javac *.java
```

Then, run the `Calculator` class using the following command:

```bash
java Calculator
```

The calculator will prompt you to enter two numbers and an operator. Enter the numbers and operator, and the calculator will display the result.

## Code Explanation

### Calculator.java

The `Calculator.java` file contains the main class that provides the user interface and handles user input. The `main` method creates a `Scanner` object to read user input. It then prompts the user to enter two numbers and an operator. The `main` method then calls the appropriate method to perform the calculation based on the operator entered by the user.

### Addition.java

The `Addition.java` file contains the `Addition` class, which performs the addition operation. The `add` method takes two numbers as input and returns their sum.

### Subtraction.java

The `Subtraction.java` file contains the `Subtraction` class, which performs the subtraction operation. The `subtract` method takes two numbers as input and returns their difference.

### Multiplication.java

The `Multiplication.java` file contains the `Multiplication` class, which performs the multiplication operation. The `multiply` method takes two numbers as input and returns their product.

### Division.java

The `Division.java` file contains the `Division` class, which performs the division operation. The `divide` method takes two numbers as input and returns their quotient.

### Exponentiation.java

The `Exponentiation.java` file contains the `Exponentiation` class, which performs the exponentiation operation. The `exponentiate` method takes two numbers as input and returns the result of raising the first number to the power of the second number.
