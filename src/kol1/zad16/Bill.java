package kol1.zad16;

import java.util.List;

public class Bill {
    private int id;
    private List<Article> articles;

    public Bill(int id, List<Article> articles) {
        this.id = id;
        this.articles = articles;
    }

    public int getId() {
        return id;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public int getTotal(){
        return articles.stream().mapToInt(Article::getPrice).sum();
    }

    public double getReturn(){
        return articles.stream().mapToDouble(a -> getReturn()).sum();
    }

    @Override
    public String toString() {
        int total = getTotal();
        double returnTax = getReturn();

        return String.format("%d %d %.2f",getId(),total,returnTax);
    }
}
