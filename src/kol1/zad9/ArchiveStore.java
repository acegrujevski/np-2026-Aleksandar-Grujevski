package kol1.zad9;

import java.time.LocalDate;
import java.util.*;

public class ArchiveStore {

    private List<Archive> archiveList;
    private List<String> logs;

    public ArchiveStore() {
        this.archiveList = new ArrayList<>();
        this.logs = new ArrayList<>();
    }

    void archiveItem(Archive item, LocalDate date){
        item.setDateArchived(date);
        archiveList.add(item);
        logs.add(item.archive());
    }


    public void openItem(int open, LocalDate date) throws NonExistingItemException {
        Archive archive = archiveList.stream().filter(a -> a.id == open).findFirst().orElse(null);

        if (archive == null)
            throw new NonExistingItemException(String.format("Item with id %d doesn't exist",open));

        logs.add(archive.open(date));
    }


    public String getLog() {
        StringBuilder sb = new StringBuilder();
        logs.forEach(sb::append);

        return sb.toString();
    }
}
