package online.books.webstore.service;

import online.books.webstore.dto.user.UserRegistrationRequestDto;
import online.books.webstore.dto.user.UserResponseDto;

public interface UserService {
    UserResponseDto register(UserRegistrationRequestDto requestDto);
}
