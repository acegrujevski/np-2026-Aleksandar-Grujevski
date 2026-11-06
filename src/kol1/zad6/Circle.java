package kol1.zad6;

public class Circle extends Shape{

    private float radius;

    public Circle(String id, Color color, float radius) {
        super(id, color);
        this.radius = radius;
    }

    @Override
    public void scale(float scaleFactor) {
        this.radius *= scaleFactor;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return String.format("C: %-5s%-10s%10.2f\n",getId(),getColor(),weight());
    }

    @Override
    public float weight() {
        return (float) (radius*radius*Math.PI);
    }
}
