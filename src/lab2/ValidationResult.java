package lab2;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {

    private final List<String> errors;

    private ValidationResult(List<String> errors) {
        this.errors = List.copyOf(errors);
    }

    public static ValidationResult ok(){
        return new ValidationResult(new ArrayList<>());
    }

    public static ValidationResult error(String message){
        if (message == null || message.isEmpty())
            throw new IllegalArgumentException();

        List<String> errors = new ArrayList<>();
        errors.add(message);

        return new ValidationResult(errors);
    }

    public static ValidationResult of(List<String> errors){

        if (errors == null)
            throw new IllegalArgumentException();

        return new ValidationResult(errors);
    }

    public boolean isValid(){
        return errors.isEmpty();
    }

    public List<String> getErrors(){
        return errors;
    }
}
