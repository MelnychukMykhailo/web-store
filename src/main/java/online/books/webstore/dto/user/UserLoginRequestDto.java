package online.books.webstore.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record UserLoginRequestDto(
        @NotEmpty
        @Size(min = 4, max = 40)
        @Email
        String email,
        @NotEmpty
        @Size(min = 4, max = 16)
        String password
) {
}
