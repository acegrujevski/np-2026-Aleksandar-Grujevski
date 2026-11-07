package kol1.zad05;

public class MinMax<T extends Comparable<T>> {
    private T minElem;
    private T maxElem;
    private int counter;
    private int minCount;
    private int maxCount;

    public MinMax() {
        this.counter = 0;
        this.minElem = null;
        this.maxElem = null;
        this.minCount = 0;
        this.maxCount = 0;
    }

    public void update(T element) {
        counter++;

        if (minElem == null) {
            minElem = element;
            maxElem = element;
            minCount = 1;
            maxCount = 1;
            return;
        }

        int cmpMin = element.compareTo(minElem);
        int cmpMax = element.compareTo(maxElem);

        if (cmpMin < 0) {
            minElem = element;
            minCount = 1;
        } else if (cmpMin == 0) {
            minCount++;
        }

        if (cmpMax > 0) {
            maxElem = element;
            maxCount = 1;
        } else if (cmpMax == 0) {
            maxCount++;
        }
    }

    private int diff() {
        if (minElem == null) return 0;
        if (minElem.compareTo(maxElem) == 0) {
            return counter - minCount;
        }
        return counter - minCount - maxCount;
    }

    public T max(){
        return maxElem;
    }

    public T min(){
        return minElem;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d",min(),max(),diff());
    }
}
