package online.books.webstore.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import online.books.webstore.dto.user.UserRegistrationRequestDto;
import online.books.webstore.dto.user.UserResponseDto;
import online.books.webstore.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "Endpoints for managing users")
public class AuthenticationController {
    private final UserService userService;

    @PostMapping("/register")
    @Operation(description = "User registration.")
    public UserResponseDto register(@RequestBody @Valid UserRegistrationRequestDto requestDto) {
        return userService.register(requestDto);
    }
}
