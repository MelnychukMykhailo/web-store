package online.books.webstore.service.impl;

import java.util.Set;
import lombok.RequiredArgsConstructor;
import online.books.webstore.dto.user.UserRegistrationRequestDto;
import online.books.webstore.dto.user.UserResponseDto;
import online.books.webstore.exception.RegistrationException;
import online.books.webstore.mapper.UserMapper;
import online.books.webstore.model.Role;
import online.books.webstore.model.User;
import online.books.webstore.repository.UserRepository;
import online.books.webstore.service.RoleService;
import online.books.webstore.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    @Override
    public UserResponseDto register(UserRegistrationRequestDto requestDto) {
        if (userRepository.existsByEmail(requestDto.getEmail())) {
            throw new RegistrationException("Such email already exist.");
        }
        User user = userMapper.toModel(requestDto);
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        Role role = roleService.getRoleByRoleName(Role.RoleName.ROLE_USER);
        user.setRoles(Set.of(role));
        return userMapper.toDto(userRepository.save(user));
    }
}
