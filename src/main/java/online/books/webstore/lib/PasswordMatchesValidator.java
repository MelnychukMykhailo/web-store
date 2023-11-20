package online.books.webstore.lib;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import online.books.webstore.dto.user.UserRegistrationRequestDto;

public class PasswordMatchesValidator implements
        ConstraintValidator<ValidByPasswordMatches, Object> {

    @Override
    public void initialize(ValidByPasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        UserRegistrationRequestDto user = (UserRegistrationRequestDto) obj;
        return user.getPassword() != null && user.getPassword().equals(user.getRepeatPassword());
    }
}
