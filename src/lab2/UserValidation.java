package lab2;

import java.util.ArrayList;
import java.util.List;

public class UserValidation {
    private static int MIN_LENGTH = 3;
    private static int MIN_EMAIL_LENGTH = 5;
    private static int MIN_AGE = 18;
    private static int MAX_AGE = 120;


    public static ValidationResult validate(User user) {

        if (user == null)
            throw new IllegalArgumentException();

        List<String> errors = new ArrayList<>();

        Validator<String> nameValidator = Validator.<String>notNull().and(Validator.minLength(MIN_LENGTH));
        ValidationResult nameResult = nameValidator.validate(user.getName());
        if (!nameResult.isValid()) {
            String out = "name:";
            for (String error : nameResult.getErrors()) {
                out += " " + error;
            }
            errors.add(out);
        }

        Validator<Integer> ageValidator = Validator.<Integer>notNull().and(Validator.range(MIN_AGE, MAX_AGE));
        ValidationResult ageResult = ageValidator.validate(user.getAge());
        if (!ageResult.isValid()) {
            String out = "age:";
            for (String error : ageResult.getErrors()) {
                out += " " + error;
            }
            errors.add(out);
        }

        Validator<String> containsAt = (v) -> v.contains("@") ? ValidationResult.ok() : ValidationResult.error("must contain @");

        Validator<String> emailValidator = Validator.<String>notNull().
                and(Validator.minLength(MIN_EMAIL_LENGTH)).and(containsAt);
        ValidationResult emailResult = emailValidator.validate(user.getEmail());
        if (!emailResult.isValid()) {
            String out = "email:";
            for (String error : emailResult.getErrors()) {
                out += " " + error;
            }
            errors.add(out);
        }

        if (errors.isEmpty())
            return ValidationResult.ok();

        return ValidationResult.of(errors);

    }
}
