package online.books.webstore.mapper;

import online.books.webstore.config.MapperConfig;
import online.books.webstore.dto.category.CategoryDto;
import online.books.webstore.dto.category.CreateCategoryRequestDto;
import online.books.webstore.model.Category;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface CategoryMapper {
    CategoryDto toDto(Category category);

    Category toModel(CreateCategoryRequestDto categoryRequestDto);
}
