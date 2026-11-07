package kol1.zad02;


import java.util.*;
import java.util.function.Predicate;

public class Canvas {
    private List<Shape> shapes;
    private String id;

    public Canvas(String id, List<Shape> shapes) {
        this.shapes = shapes;
        this.id = id;
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public int size(){
        return shapes.size();
    }

    public double getTotalArea(){
        return shapes.stream().mapToDouble(Shape::getArea).sum();
    }

    public int countBy(Predicate<Shape> predicate){
        return (int)shapes.stream().filter(predicate).count();
    }

    public double getMinArea(){
        return shapes.stream().mapToDouble(Shape::getArea).min().orElse(0.0);
    }

    public double getMaxArea(){
        return shapes.stream().mapToDouble(Shape::getArea).max().orElse(0.0);
    }

    public double getAvgArea(){
        return shapes.stream().mapToDouble(Shape::getArea).average().orElse(0.0);
    }

    public String getId() {
        return id;
    }
}
