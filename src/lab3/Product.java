package lab3;

public abstract class Product implements Comparable<Product> {

    protected int id;
    protected String name;
    protected String category;
    protected double basePrice;

    public Product(int id, String name, String category, double basePrice) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.basePrice = basePrice;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public abstract double getFinalPrice();

    public abstract char getTypeCode();

    public static Product createProduct(String line) throws InvalidProductException {

        String [] parts = line.trim().split(";",-1);

        if (parts.length != 6)
            throw new InvalidProductException(line);

        String type = parts[0];

        if (!type.equals("P") && !type.equals("D"))
            throw new InvalidProductException(line);

        try {
            int id = Integer.parseInt(parts[1]);
            String name = parts[2];
            String category = parts[3];
            double basePrice = Double.parseDouble(parts[4]);

            if (basePrice<0)
                throw new InvalidProductException(line);

            if (type.equals("D")) {
                int sizeMb = Integer.parseInt(parts[5]);

                if (sizeMb <= 0)
                    throw new InvalidProductException(line);

                return new DigitalProduct(id, name, category, basePrice, sizeMb);
            } else {
                double weight = Double.parseDouble(parts[5]);

                if (weight <= 0)
                    throw new InvalidProductException(line);

                return new PhysicalProduct(id, name, category, basePrice, weight);
            }
        }catch (NumberFormatException e){
            throw new InvalidProductException(line);
        }

    }

    @Override
    public int compareTo(Product other) {

        int priceCmp = Double.compare(getFinalPrice(),other.getFinalPrice());
        if (priceCmp != 0)
            return priceCmp;

        int nameCmp = name.compareTo(other.getName());
        if (nameCmp != 0)
            return nameCmp;

        return Integer.compare(id,other.getId());
    }

    @Override
    public String toString() {
        char typeCode = getTypeCode();
        double finalPrice = getFinalPrice();
        return String.format("%c %-5d %-15s %-12s %10.2f", typeCode, id, name, category, finalPrice);
    }
}
