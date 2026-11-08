package kol1.zad18;

public class CategoryNotFoundException extends Exception {
    public CategoryNotFoundException(String category) {
        super(String.format("Category %s was not found", category));
    }
}
