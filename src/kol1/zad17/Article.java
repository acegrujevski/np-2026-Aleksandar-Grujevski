package kol1.zad17;

public class Article {

    private int price;
    private Tax_Type type;

    public Article(int price, Tax_Type type) {
        this.price = price;
        this.type = type;
    }

    public double getReturn(){
        double total = getPrice();

        if (type.equals(Tax_Type.A))
            total *= 0.18;
        else if (type.equals(Tax_Type.B))
            total *= 0.05;
        else
            total = 0.0;

        return total*0.15;
    }

    public int getPrice() {
        return price;
    }

    public Tax_Type getType() {
        return type;
    }
}
