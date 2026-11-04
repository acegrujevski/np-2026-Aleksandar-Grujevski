package kol1.zad2;

public class Square extends Shape{

    public Square(int size) {
        super(size);
    }

    @Override
    public double getArea() {
        return size*size;
    }
}
