package kol1.zad16;

public class Article {
    private int price;
    private Tax_Type type;

    public Article(int price, Tax_Type type) {
        this.price = price;
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public Tax_Type getType() {
        return type;
    }

    public double taxReturn(){
        double taxed = getPrice();
        if (type.equals(Tax_Type.A))
            taxed*= 0.18F;
        else if (type.equals(Tax_Type.B))
            taxed*= 0.05F;
        else
            taxed = 0;

        return taxed * 0.15F;
    }
}
