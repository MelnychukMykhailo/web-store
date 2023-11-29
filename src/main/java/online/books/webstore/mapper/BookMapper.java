package online.books.webstore.mapper;

import java.util.stream.Collectors;
import online.books.webstore.config.MapperConfig;
import online.books.webstore.dto.book.BookDto;
import online.books.webstore.dto.book.BookDtoWithoutCategoryIds;
import online.books.webstore.dto.book.CreateBookRequestDto;
import online.books.webstore.model.Book;
import online.books.webstore.model.Category;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    @Mapping(target = "categoryIds", ignore = true)
    BookDto toDto(Book book);

    @Mapping(target = "categories", ignore = true)
    Book toModel(CreateBookRequestDto createBookRequestDto);

    BookDtoWithoutCategoryIds toDtoWithoutCategoryIds(Book book);

    @AfterMapping
    default void setCategoryIds(@MappingTarget BookDto bookDto, Book book) {
        bookDto.setCategoryIds(book.getCategories()
                .stream()
                .map(Category::getId)
                .collect(Collectors.toSet()));
    }
}
