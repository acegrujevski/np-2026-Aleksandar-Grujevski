package kol1.zad9;

import java.time.LocalDate;
import java.util.Date;

public class SpecialArchive extends Archive {

    private int maxOpen;
    private int counter;

    public SpecialArchive(int id, int maxOpen) {
        super(id);
        this.maxOpen = maxOpen;
        this.counter = 0;
    }

    @Override
    public String open(LocalDate date) {
        if (counter == maxOpen)
            return String.format("Item %d cannot be opened more than %d times\n",this.id,this.maxOpen);
        counter++;
        return super.open(date);
    }
}
