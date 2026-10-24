package aud1.zad3;

import java.util.Scanner;

public class Tester {

    static final char RESULT = 'r';

    static char firstToLower(String string){
        if (string.trim().length() == 0) return '?';
        return Character.toLowerCase(string.charAt(0));
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true){
            Calculator calculator = new Calculator();
            System.out.println(calculator.start());

            while (true){
                String line = scanner.nextLine();
                char input = firstToLower(line);

                if (input == RESULT){
                    System.out.println("final result = " + calculator.getResult());
                    break;
                }

                String[] parts = line.split("\\s+");
                if (parts.length < 2){
                    System.out.println("Please enter: <operator> <number>");
                    continue;
                }

                char operator = parts[0].charAt(0);
                double num = Double.parseDouble(parts[1]);

                String result = null;
                try {
                    result = calculator.operate(operator, num);
                    System.out.println(result);
                    System.out.println(calculator);
                } catch (UnknownOperatorException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("(Y/N)");

            String line2= scanner.nextLine();

            char input2 = firstToLower(line2);

            if (input2 == 'n') {
                break;
            }
        }
    }
}
