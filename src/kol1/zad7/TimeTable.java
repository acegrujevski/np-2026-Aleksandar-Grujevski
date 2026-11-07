package kol1.zad7;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class TimeTable {
    private List<Time> timeList;

    public TimeTable(){
        timeList = new ArrayList<>();
    }

    public void readTimes(InputStream in) throws InvalidTimeException, UnsupportedFormatException{
        Scanner sc = new Scanner(in);

        while (sc.hasNext()){
            String line = sc.nextLine();
            String [] parts = line.trim().split("\\s+");

            for (String s : parts){
                try {
                    if (s.contains(":")){
                        String [] time = s.trim().split(":");
                        int hour = Integer.parseInt(time[0]);
                        int minutes = Integer.parseInt(time[1]);
                        if (hour<0 || hour>23 || minutes<0 || minutes>59)
                            throw new InvalidTimeException("Invalid time: " + s);

                        timeList.add(new Time(hour,minutes));
                    }
                    else if (s.contains(".")){
                        String [] time = s.trim().split("\\.");
                        int hour = Integer.parseInt(time[0]);
                        int minutes = Integer.parseInt(time[1]);
                        if (hour<0 || hour>23 || minutes<0 || minutes>59)
                            throw new InvalidTimeException("Invalid time: " + s);

                        timeList.add(new Time(hour,minutes));
                    }
                    else {
                        throw new UnsupportedFormatException("UnsupportedFormatException: " + s);
                    }
                } catch (InvalidTimeException | UnsupportedFormatException e){
                    System.out.println(e.getMessage());
                }

            }
        }
    }

    public void writeTimes(PrintStream out, TimeFormat timeFormat) {
        PrintWriter pw = new PrintWriter(out);

        timeList = timeList.stream().sorted(Comparator.comparingInt(Time::getSeconds)).collect(Collectors.toList());

        if (timeFormat.equals(TimeFormat.FORMAT_AMPM)) {
            timeList.forEach(time -> {
                if (time.getHour()>=12) {
                    time.setHour(time.getHour() - 12);
                    if(time.getHour() == 0)
                        time.setHour(12);
                    String indent = time.getHour()<10 ? " " : "";
                    pw.println(indent + time.toString() + " PM");
                }
                else{
                    if(time.getHour() == 0)
                        time.setHour(12);
                    String indent = time.getHour()<10 ? " " : "";
                    pw.println(indent + time.toString() + " AM");
                }
            });
        }
        else{
            timeList.forEach(time -> {
                String indent = time.getHour()<10 ? " " : "";
                pw.println(indent + time.toString());
            });
        }
        pw.flush();
    }
}
