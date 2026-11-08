package lab3;

public class CategoryNotFoundException extends Exception {
  public CategoryNotFoundException(String category) {
    super(String.format("Category %s not found",category));
  }
}
