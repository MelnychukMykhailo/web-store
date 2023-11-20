package online.books.webstore.mapper;

import online.books.webstore.config.MapperConfig;
import online.books.webstore.dto.book.BookDto;
import online.books.webstore.dto.book.CreateBookRequestDto;
import online.books.webstore.model.Book;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    Book toModel(CreateBookRequestDto createBookRequestDto);
}
