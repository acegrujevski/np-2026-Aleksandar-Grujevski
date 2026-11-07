package kol1.zad09;

import java.time.LocalDate;
import java.util.*;

public abstract class Archive {
    protected int id;
    protected LocalDate dateArchived;

    public Archive(int id) {
        this.id = id;
    }

    public void setDateArchived(LocalDate dateArchived) {
        this.dateArchived = dateArchived;
    }

    public String archive(){
        return String.format("Item %d archived at %s\n",this.id,this.dateArchived);
    }

    public String open(LocalDate date){
        return String.format("Item %d opened at %s\n",this.id,date);
    }
}
