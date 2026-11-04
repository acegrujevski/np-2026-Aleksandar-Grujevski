package kol1.zad2;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ShapesApplication {

    private double maxArea;
    private List<Canvas> canvasList = new ArrayList<>();

    public ShapesApplication(double maxArea) {
        this.maxArea = maxArea;
    }

    public void readCanvases(InputStream in) throws IrregularCanvasException {
        Scanner scanner = new Scanner(in);

        while (scanner.hasNextLine()){
            String line = scanner.nextLine().trim();

            if (line.isEmpty())
                continue;

            String[] parts = line.split("\\s+");

            String id = parts[0];
            try {


                List<Shape> shapes = new ArrayList<>();

                for (int i = 1; i < parts.length; i += 2) {

                    Shape shape;

                    if (parts[i].toLowerCase().equals("c")) {
                        shape = new Circle(Integer.parseInt(parts[i + 1]));
                    } else {
                        shape = new Square(Integer.parseInt(parts[i + 1]));
                    }

                    if (shape.getArea() > maxArea)
                        throw new IrregularCanvasException(String.format("Canvas %s has a shape with area larger than %.2f", id, maxArea));

                    shapes.add(shape);
                }

                canvasList.add(new Canvas(id, shapes));
            } catch (IrregularCanvasException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void printCanvases(PrintStream out) {
        PrintWriter printWriter = new PrintWriter(out);

        canvasList = canvasList.stream().sorted(Comparator.comparing(Canvas::getTotalArea).reversed()).toList();

        canvasList.stream().forEach(canvas -> {
            int countCircles = canvas.countBy(shape -> shape instanceof Circle);
            int countSquares = canvas.countBy(shape -> shape instanceof Square);
            int count = countCircles + countSquares;
            double max = canvas.getMaxArea();
            double min = canvas.getMinArea();
            double avg = canvas.getAvgArea();

            printWriter.println(String.format("%s %d %d %d %.2f %.2f %.2f", canvas.getId(), count, countCircles, countSquares, min, max, avg));
        });

        printWriter.flush();
    }

    public double getMaxArea() {
        return maxArea;
    }
}
