package kol1.zad15;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class WeatherStation {

    private final double DIFF = 2.5*60*1000;
    private int days;
    private List<Measurement> measurements;

    public WeatherStation(int days) {
        this.days = days;
        this.measurements = new ArrayList<>();
    }

    public long daysToMiliSec(){
        return (long) days *24*60*60*1000;
    }

    public void addMeasurment(float temperature, float wind, float humidity, float visibility, Date date) {
        Measurement measurement = new Measurement(temperature,wind,humidity,visibility,date);

        measurements.removeIf(m -> (measurement.toMiliSec()-m.toMiliSec()) > daysToMiliSec());

        for (Measurement m : measurements)
            if(Math.abs(m.toMiliSec()-measurement.toMiliSec()) < DIFF)
                return;

        measurements.add(measurement);
    }

    public int total() {
        return measurements.size();
    }

    public void status(Date from, Date to) throws RuntimeException {
        List<Measurement> newMeasurements = measurements.stream().
                filter(m -> m.getDate().compareTo(from) >= 0 && m.getDate().compareTo(to) <= 0).collect(Collectors.toList());

        if (newMeasurements.isEmpty())
            throw new RuntimeException();

        newMeasurements.forEach(m -> System.out.println(m));

        double avg = newMeasurements.stream().mapToDouble(Measurement::getTemperature).average().orElse(0.0);
        System.out.println(String.format("Average temperature: %.2f",avg));
    }
}
