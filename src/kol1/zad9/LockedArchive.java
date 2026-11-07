package kol1.zad9;
import java.time.LocalDate;
import java.util.*;

public class LockedArchive extends Archive {

    private LocalDate dateToOpen;

    public LockedArchive(int id, LocalDate dateToOpen) {
        super(id);
        this.dateToOpen = dateToOpen;
    }

    @Override
    public String open(LocalDate date) {
        if (date.compareTo(this.dateToOpen) < 0)
            return String.format("Item %d cannot be opened before %s\n",id,dateToOpen);
        return super.open(date);
    }
}
