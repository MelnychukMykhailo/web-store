package online.books.webstore.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import online.books.webstore.dto.BookDto;
import online.books.webstore.dto.CreateBookRequestDto;
import online.books.webstore.mapper.BookMapper;
import online.books.webstore.model.Book;
import online.books.webstore.repository.BookRepository;
import online.books.webstore.service.BookService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto save(CreateBookRequestDto createBookRequestDto) {
        Book book = bookMapper.toModel(createBookRequestDto);
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto getBookById(Long id) {
        return bookMapper.toDto(bookRepository.getBookById(id));
    }
}
