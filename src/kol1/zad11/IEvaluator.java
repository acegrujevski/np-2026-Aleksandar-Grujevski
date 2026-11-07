package kol1.zad11;

@FunctionalInterface
public interface IEvaluator<T extends Comparable<T>> {
    public boolean evaluate (T a, T b);
}
