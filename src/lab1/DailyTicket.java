package lab1;

public class DailyTicket extends Ticket {

    public static final int DAY = 1440;
    public static final int PRICE = 300;

    public DailyTicket(String plate, int minutes){
        super(plate, minutes);
    }

    @Override
    public double price() {
        if (getMinutes() <= DAY)
            return PRICE;
        return (getMinutes()/DAY + 1)*PRICE;
    }
}
