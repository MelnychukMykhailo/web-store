package online.books.webstore.mapper;

import online.books.webstore.config.MapperConfig;
import online.books.webstore.dto.user.UserRegistrationRequestDto;
import online.books.webstore.dto.user.UserResponseDto;
import online.books.webstore.model.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserResponseDto toDto(User user);

    User toModel(UserRegistrationRequestDto userRegistrationRequestDto);
}
