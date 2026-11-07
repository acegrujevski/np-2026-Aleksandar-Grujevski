package kol1.zad12;

public class GenericFraction <T extends Number, U extends Number>{
    private T numerator;
    public U denominator;

    public GenericFraction(T numerator, U denominator) throws ZeroDenominatorException {
        if (denominator.equals(0))
            throw new ZeroDenominatorException("Denominator cannot be zero");
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public T getNumerator() {
        return numerator;
    }

    public U getDenominator() {
        return denominator;
    }

    public GenericFraction<Double, Double> add(GenericFraction<? extends Number, ? extends Number> gf) throws ZeroDenominatorException {

        double numerator = this.numerator.intValue() * gf.denominator.intValue() + gf.numerator.intValue() * this.denominator.intValue();
        double denominator = this.denominator.intValue() * gf.denominator.intValue();
        return new GenericFraction<>(numerator,denominator);
    }

    public double toDouble(){
        return this.numerator.doubleValue()/this.denominator.doubleValue();
    }

    public int gcd(){
        int a = this.numerator.intValue();
        int b = this.denominator.intValue();
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    @Override
    public String toString() {
        return String.format("%.2f / %.2f",this.numerator.doubleValue()/gcd(),this.denominator.doubleValue()/gcd());
    }
}
