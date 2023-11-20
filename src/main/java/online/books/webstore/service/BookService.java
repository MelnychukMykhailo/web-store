package online.books.webstore.service;

import java.util.List;
import online.books.webstore.dto.book.BookDto;
import online.books.webstore.dto.book.BookSearchParametersDto;
import online.books.webstore.dto.book.CreateBookRequestDto;
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
