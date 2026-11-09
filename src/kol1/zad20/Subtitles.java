package kol1.zad20;
import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Subtitles {

    private List<Time> times;


    public Subtitles() {
        times = new ArrayList<>();
    }

    public int loadSubtitles(InputStream inputStream) {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        int count = 0;

        try {
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                int id = Integer.parseInt(line);

                String timeLine = br.readLine().trim();
                String[] parts = timeLine.split("-->");

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss,SSS");
                LocalTime start = LocalTime.parse(parts[0].trim(), formatter);
                LocalTime end = LocalTime.parse(parts[1].trim(), formatter);

                StringBuilder sb = new StringBuilder();

                String l;
                while ((l = br.readLine()) != null){
                    if (l.isBlank())
                        break;
                    sb.append(l + "\n");
                }

                String textLine = sb.toString();

                times.add(new Time(id, start, end, textLine));
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }

    public void print() {
        times.forEach(Time::print);
    }

    public void shift(int ms) {
        times.forEach(t -> t.shift(ms));
    }
}
