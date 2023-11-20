package online.books.webstore.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import online.books.webstore.lib.ValidByPasswordMatches;

@Data
@ValidByPasswordMatches
public class UserRegistrationRequestDto {
    @Email
    private String email;
    @NotNull
    @Size(min = 4, max = 16)
    private String password;
    private String repeatPassword;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String shippingAddress;
}
