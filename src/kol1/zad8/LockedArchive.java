package kol1.zad8;
import java.util.*;

public class LockedArchive extends Archive {

    private Date dateToOpen;

    public LockedArchive(int id, Date dateToOpen) {
        super(id);
        this.dateToOpen = dateToOpen;
    }

    @Override
    public String open(Date date) {
        if (date.compareTo(this.dateToOpen) < 0)
            return String.format("Item %d cannot be opened before %s\n",id,dateToOpen);
        return super.open(date);
    }
}
