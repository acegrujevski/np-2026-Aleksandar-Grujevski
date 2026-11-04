package kol1.zad2;

public class Circle extends Shape{

    public Circle(int size) {
        super(size);
    }

    @Override
    public double getArea() {
        return size*size*Math.PI;
    }
}
