package aud1.zad3;

public class CalculatorLogic {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';

    private static final Operation ADDITION = (r, n) -> r+n;
    private static final Operation SUBTRACTION = (r, n) -> r-n;
    private static final Operation MULTIPLICATION = (r, n) -> r*n;
    private static final Operation DIVISION = (r, n) -> n!=0 ? r/n : r;

    public static Operation getOperation (char operator, double num) throws UnknownOperatorException {
        if(operator == PLUS)
            return ADDITION;
        else if (operator == MINUS)
            return SUBTRACTION;
        else if (operator == MULTIPLY)
            return MULTIPLICATION;
        else if (operator == DIVIDE)
            return DIVISION;
        else throw new UnknownOperatorException(operator);
    }

}
