package kol1.zad6;

import java.util.*;

public class Canvas {

    private List<Shape> shapes;

    public Canvas() {
        this.shapes = new ArrayList<>();
    }

    public void add(String id, Color color, float radius){
        Shape circle = new Circle(id,color,radius);

        int i = insertSort(circle);

        shapes.add(i,circle);
    }


    public void add(String id, Color color, float width, float height){
        Shape rectangle = new Rectangle(id,color,width,height);

        int i = insertSort(rectangle);

        shapes.add(i,rectangle);
    }

    public int insertSort(Shape shape){
        int i;
        for (i=0; i < shapes.size(); i++) {
            if (shape.weight()>shapes.get(i).weight())
                break;
        }

        return i;
    }

    public void scale(String id, float scaleFactor){

        Shape shape = null;

        for (Shape shape1 : shapes)
            if (shape1.getId().equals(id)) shape = shape1;

        shapes.remove(shape);

        shape.scale(scaleFactor);

        int i = insertSort(shape);

        shapes.add(i,shape);

    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        shapes.forEach(stringBuilder::append);

        return stringBuilder.toString();
    }
}
