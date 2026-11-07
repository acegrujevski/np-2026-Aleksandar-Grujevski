package kol1.zad11;

public class EvaluatorBuilder {

    public static <T extends Comparable<T>> IEvaluator<T> build (String operator){

        if (operator.equals(">"))
            return (a, b) -> a.compareTo(b) > 0;
        else if (operator.equals("<"))
            return (a, b) -> a.compareTo(b) < 0;
        else if (operator.equals("=="))
            return (a, b) -> a.compareTo(b) == 0;
        else if (operator.equals("!="))
            return (a, b) -> a.compareTo(b) != 0;
        else
            return null;
    }
}
