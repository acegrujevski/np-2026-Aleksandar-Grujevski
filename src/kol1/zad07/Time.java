package kol1.zad07;

public class Time {
    private int hour;
    private int minutes;

    public Time(int hour, int minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getHour() {
        return hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds(){
        return getHour()*3600 + getMinutes()*60;
    }

    @Override
    public String toString() {
        return getHour() + ":" + (getMinutes()<10 ? "0"+getMinutes() : getMinutes());
    }
}
