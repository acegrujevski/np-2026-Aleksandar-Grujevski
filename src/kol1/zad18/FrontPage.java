package kol1.zad18;

import java.util.*;
import java.util.stream.Collectors;

public class FrontPage {
    private List<NewsItem> newsItems;
    private Category[] categories;

    public FrontPage(Category[] categories) {
        this.categories = categories;
        this.newsItems = new ArrayList<>();
    }

    void addNewsItem(NewsItem newsItem){
        newsItems.add(newsItem);
    }

    List<NewsItem> listByCategory(Category category){
        return newsItems.stream().filter(n -> n.getCategory().equals(category)).collect(Collectors.toList());
    }

    List<NewsItem> listByCategoryName(String category) throws CategoryNotFoundException {
        Optional<Category> cat = Arrays.stream(categories).filter(c -> c.getName().equals(category)).findFirst();

        if (cat.isEmpty())
            throw new CategoryNotFoundException(category);

        return listByCategory(cat.get());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        newsItems.forEach(n -> sb.append(n.getTeaser()));

        return sb.toString();
    }
}
