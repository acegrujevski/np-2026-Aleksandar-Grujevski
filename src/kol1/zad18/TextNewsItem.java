package kol1.zad18;

import java.util.Date;

public class TextNewsItem extends NewsItem {

    private String text;

    public TextNewsItem(String title, Date releaseDate, Category category, String text) {
        super(title, releaseDate, category);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String getTeaser() {
        return super.getTeaser() + text.substring(0,Math.min(text.length(),80)) + "\n";
    }
}
