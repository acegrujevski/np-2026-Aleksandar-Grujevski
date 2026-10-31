package lab2;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
public interface Validator<T> {
    ValidationResult validate(T value);

    default Validator<T> and(Validator<? super T> other){
        if (other == null)
            throw new IllegalArgumentException();

        return (v) -> {

            ValidationResult result = this.validate(v);

            if (!result.isValid()) {
                return result;
            }

            return other.validate(v);
        };
    }

    static <T> Validator<T> notNull(){
        return (v) -> {
          if (v == null)
              return ValidationResult.error("must not be null");

          return ValidationResult.ok();
        };
    }

    static Validator<String> minLength(int min){
        if (min < 0)
            throw new IllegalArgumentException();

        return (v) -> {

            if (v == null)
                return ValidationResult.error("must not be null");

            if (v.length() < min)
                return ValidationResult.error(String.format("must have at least %d characters", min));

            return ValidationResult.ok();
        };
    }

    static Validator<Integer> range(int min, int max){

        if (min > max)
            throw new IllegalArgumentException();

        return (v) -> {

            if (v == null)
                return ValidationResult.error("must not be null");

            if (v < min || v > max)
                return ValidationResult.error(String.format("must be between %d and %d",min,max));

            return ValidationResult.ok();
        };
    }
}
