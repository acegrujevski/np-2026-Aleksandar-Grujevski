package kol1.zad2;

public abstract class Shape {
    protected int size;

    public Shape(int size) {
        this.size = size;
    }


    public abstract double getArea();
}

