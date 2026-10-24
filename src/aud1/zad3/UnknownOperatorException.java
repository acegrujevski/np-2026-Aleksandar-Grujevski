package aud1.zad3;

public class UnknownOperatorException extends Exception {
    public UnknownOperatorException(char operator) {
      super("Operator: " + operator + " is invalid!");
    }
}
