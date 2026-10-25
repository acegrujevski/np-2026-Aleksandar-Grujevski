package lab1;

public abstract class Ticket {

    private final String plate;
    private final int minutes;

    protected Ticket(String plate, int minutes){
        if (plate == null || plate.equals("") || minutes <= 0)
            throw new IllegalArgumentException();
        this.plate = plate;
        this.minutes = minutes;
    }

    public String getPlate() {
        return plate;
    }

    public int getMinutes() {
        return minutes;
    }

    public abstract double price();

    @Override
    public String toString() {
        return "Ticket{" +
                "plate='" + plate + '\'' +
                ", minutes=" + minutes +
                '}';
    }
}
