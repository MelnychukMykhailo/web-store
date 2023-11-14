package online.books.webstore.service;

import java.util.List;
import online.books.webstore.dto.BookDto;
import online.books.webstore.dto.BookSearchParametersDto;
import online.books.webstore.dto.CreateBookRequestDto;
import org.springframework.data.domain.Pageable;

public interface BookService {
    BookDto save(CreateBookRequestDto createBookRequestDto);

    List<BookDto> findAll(Pageable pageable);

    BookDto getBookById(Long id);

    BookDto updateBookById(Long id,
                           CreateBookRequestDto createBookRequestDto);

    void deleteBookById(Long id);

    List<BookDto> search(BookSearchParametersDto params);
}
