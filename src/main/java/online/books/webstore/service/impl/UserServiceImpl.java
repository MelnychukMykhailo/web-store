package online.books.webstore.service.impl;

import lombok.RequiredArgsConstructor;
import online.books.webstore.dto.user.UserRegistrationRequestDto;
import online.books.webstore.dto.user.UserResponseDto;
import online.books.webstore.exception.RegistrationException;
import online.books.webstore.mapper.UserMapper;
import online.books.webstore.model.User;
import online.books.webstore.repository.user.UserRepository;
import online.books.webstore.service.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto register(UserRegistrationRequestDto requestDto) {
        if (userRepository.existsByEmail(requestDto.getEmail())) {
            throw new RegistrationException("Such email is already exist.");
        }
        User user = userMapper.toModel(requestDto);
        return userMapper.toDto(userRepository.save(user));
    }
}
