package kol1.zad17;

import java.util.List;

public class Bill {
    private int id;
    private List<Article> articles;

    public Bill(int id, List<Article> articles) {
        this.id = id;
        this.articles = articles;
    }

    public int getTotalPrice(){
        return articles.stream().mapToInt(Article::getPrice).sum();
    }

    public double getTotalReturn(){
        return articles.stream().mapToDouble(Article::getReturn).sum();
    }

    public int getId() {
        return id;
    }

    public List<Article> getArticles() {
        return articles;
    }

    @Override
    public String toString() {
        return String.format("%10d\t%10d\t%10.5f",getId(),getTotalPrice(),getTotalReturn());
    }
}
