package lab1;

public class HourlyTicket extends Ticket {

    public static final int PRICE = 50;
    public static final int HOUR = 60;

    public HourlyTicket(String plate, int minutes){
        super(plate, minutes);
    }

    @Override
    public double price(){
        if (getMinutes() <= HOUR)
            return PRICE;
        return (getMinutes()/HOUR + 1)*PRICE;
    }


}
