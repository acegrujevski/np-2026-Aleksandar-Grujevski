package kol1.zad18;

import java.util.Date;

public class MediaNewsItem extends NewsItem {

    private String url;
    private int views;

    public MediaNewsItem(String title, Date releaseDate, Category category, String url, int views) {
        super(title, releaseDate, category);
        this.url = url;
        this.views = views;
    }

    public String getUrl() {
        return url;
    }

    public int getViews() {
        return views;
    }

    @Override
    public String getTeaser() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getTeaser());
        sb.append(url + "\n");
        sb.append(views + "\n");

        return sb.toString();
    }
}
