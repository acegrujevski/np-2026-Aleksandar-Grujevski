package kol1.zad8;

import java.util.*;

public abstract class Archive {
    protected int id;
    protected Date dateArchived;

    public Archive(int id) {
        this.id = id;
    }

    public void setDateArchived(Date dateArchived) {
        this.dateArchived = dateArchived;
    }

    public String archive(){
        return String.format("Item %d archived at %s\n",this.id,this.dateArchived);
    }

    public String open(Date date){
        return String.format("Item %d opened at %s\n",this.id,date);
    }
}
