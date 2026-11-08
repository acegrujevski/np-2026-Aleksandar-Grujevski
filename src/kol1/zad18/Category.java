package kol1.zad18;


public class Category {
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Category o) {
        return name.equals(o.getName());
    }
}
