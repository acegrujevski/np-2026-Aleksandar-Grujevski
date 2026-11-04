package kol1.zad1;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShapesApplication {

    private List<Canvas> canvasList;

    public int readCanvases(InputStream in) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        this.canvasList = reader.lines().
                map(String::trim).
                filter(l -> !l.isEmpty()).
                map(l -> {
                    String [] parts = l.split("\\s+");
                    String id = parts[0];

                    List<Square> squares = Arrays.stream(parts,1,parts.length).
                            map(Integer::parseInt).
                            map(Square::new).collect(Collectors.toList());

                    return new Canvas(id,squares);
                }).collect(Collectors.toList());

        return canvasList.stream().mapToInt(Canvas::getSizes).sum();
    }

    public void printLargestCanvasTo(PrintStream out) {
        PrintWriter writer = new PrintWriter(out);

        if (canvasList.isEmpty())
            return;

        canvasList.stream().max(Comparator.comparingInt(Canvas::sumAll)).
                ifPresent(canvas -> writer.println(canvas));

        writer.flush();
    }
}
