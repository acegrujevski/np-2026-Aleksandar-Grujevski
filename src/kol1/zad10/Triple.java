package kol1.zad10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Triple<T extends Number> {
    private List<T> numbers;

    public Triple(T a, T b, T c) {
        numbers = new ArrayList<>();
        numbers.add(a);
        numbers.add(b);
        numbers.add(c);
    }

    public double max(){
        return numbers.stream().mapToDouble(Number::doubleValue).max().orElse(0.0);
    }

    public double avarage(){
        return numbers.stream().mapToDouble(Number::doubleValue).average().orElse(0.0);
    }

    void sort (){
        numbers = numbers.stream().sorted(Comparator.comparingDouble(Number::doubleValue)).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return String.format("%.2f %.2f %.2f",numbers.get(0).doubleValue(),numbers.get(1).doubleValue(),numbers.get(2).doubleValue());
    }
}
