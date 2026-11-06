package kol1.zad6;

public abstract class Shape implements Scalable,Stackable{
    protected String id;
    protected Color color;

    public Shape(String id, Color color) {
        this.id = id;
        this.color = color;
    }

    public abstract String getId();

    public abstract Color getColor();

    @Override
    public abstract String toString();
}
