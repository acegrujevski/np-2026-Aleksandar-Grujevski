package lab3;

public class PhysicalProduct extends Product {
    private double weight;

    public PhysicalProduct(int id, String name, String category, double basePrice, double weight) {
        super(id, name, category, basePrice);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public double getShippingCost() {
        return weight <= 1 ? 60 : 60 + 30 * (weight - 1);
    }

    @Override
    public double getFinalPrice() {
        return basePrice + getShippingCost();
    }

    @Override
    public char getTypeCode() {
        return 'P';
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | %.2f kg", weight);
    }
}
