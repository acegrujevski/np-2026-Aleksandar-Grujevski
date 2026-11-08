package lab3;

public class DigitalProduct extends Product {
    private int sizeMb;

    public DigitalProduct(int id, String name, String category, double basePrice, int sizeMb) {
        super(id, name, category, basePrice);
        this.sizeMb = sizeMb;
    }

    public int getSizeMb() {
        return sizeMb;
    }

    @Override
    public double getFinalPrice() {
        return basePrice * 0.9;
    }

    @Override
    public char getTypeCode() {
        return 'D';
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | %d MB", sizeMb);
    }
}
