package kol1.zad18;
import java.util.*;

public abstract class NewsItem {

    protected String title;
    protected Date releaseDate;
    protected Category category;

    public NewsItem(String title, Date releaseDate, Category category) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public Category getCategory() {
        return category;
    }

    public String getTeaser(){
        StringBuilder sb = new StringBuilder();

        sb.append(title+"\n");
        long minutes = (new Date().getTime() - releaseDate.getTime()) / (1000 * 60);
        sb.append(minutes+"\n");

        return sb.toString();
    };
}
