package online.books.webstore.service;

import java.util.List;
import online.books.webstore.dto.BookDto;
import online.books.webstore.dto.CreateBookRequestDto;

public interface BookService {
    BookDto save(CreateBookRequestDto createBookRequestDto);

    List<BookDto> findAll();

    BookDto getBookById(Long id);

    BookDto updateBookById(Long id,
                           CreateBookRequestDto createBookRequestDto);

    void deleteBookById(Long id);
}
