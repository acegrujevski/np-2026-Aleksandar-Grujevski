package aud1.zad3;

public class Calculator {
    private double result;

    public Calculator() {
        this.result = 0.0;
    }

    public String start(){
        return "result = " + result;
    }

    public double getResult() {
        return result;
    }

    public String operate(char operator, double num) throws UnknownOperatorException {
        Operation operation = CalculatorLogic.getOperation(operator,num);
        result = operation.operate(result, num);
        return "result " + operator + " " + num + " " + result;
    }

    @Override
    public String toString() {
        return "updated result = " + result;
    }
}
