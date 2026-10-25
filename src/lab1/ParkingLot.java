package lab1;

public class ParkingLot {

    private Ticket[] tickets;
    private int ticketCount;
    private int capacity;


    public ParkingLot(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException();
        tickets = new Ticket[capacity];
        ticketCount = 0;
        this.capacity = capacity;
    }

    public void addTicket(Ticket ticket) throws LotFullException{
        if (ticket == null)
            throw new IllegalArgumentException();
        if (isFull())
            throw new LotFullException();
        tickets[ticketCount++] = ticket;
    }

    public int getTicketCount(){
        return ticketCount;
    }

    public double totalRevenue(){

        if (isEmpty())
            return 0.0;

        double total = 0.0;

        for (int i = 0; i < ticketCount; i++)
            total += tickets[i].price();

        return total;
    }

    public boolean isFull(){
        return ticketCount==capacity;
    }

    public boolean isEmpty(){
        return ticketCount == 0;
    }
}
