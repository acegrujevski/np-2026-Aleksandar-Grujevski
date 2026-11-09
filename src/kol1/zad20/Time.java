package kol1.zad20;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Time {

    private int id;
    private LocalTime startTime;
    private LocalTime endTime;
    private String text;

    public Time(int id, LocalTime startTime, LocalTime endTime, String text) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.id = id;
        this.text = text;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void shift(int ms) {
        long nanoSec = (long) ms * 1000000;
        this.startTime = this.startTime.plusNanos(nanoSec);
        this.endTime = this.endTime.plusNanos(nanoSec);
    }

    public void print() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss,SSS");
        System.out.println(String.format("%d\n%s --> %s\n%s", id, startTime.format(formatter), endTime.format(formatter), text));
    }
}
