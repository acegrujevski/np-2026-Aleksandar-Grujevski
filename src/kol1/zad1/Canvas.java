package kol1.zad1;

import java.util.List;

public class Canvas {
    private String id;
    private List<Square> sizes;

    public Canvas(String id, List<Square> sizes) {
        this.id = id;
        this.sizes = sizes;
    }

    public String getId() {
        return id;
    }

    public int getSizes() {
        return sizes.size();
    }

    public int sumAll(){
        return sizes.stream().mapToInt(s -> s.getSize()*4).sum();
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", id, getSizes(), sumAll());
    }
}
