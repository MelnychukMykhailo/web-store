package online.books.webstore.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import online.books.webstore.dto.BookDto;
import online.books.webstore.dto.BookSearchParametersDto;
import online.books.webstore.dto.CreateBookRequestDto;
import online.books.webstore.exception.DataProcessingException;
import online.books.webstore.exception.EntityNotFoundException;
import online.books.webstore.mapper.BookMapper;
import online.books.webstore.model.Book;
import online.books.webstore.repository.book.BookRepository;
import online.books.webstore.repository.book.BookSpecificationBuilder;
import online.books.webstore.service.BookService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final BookSpecificationBuilder bookSpecificationBuilder;

    @Override
    public BookDto save(CreateBookRequestDto createBookRequestDto) {
        if (bookRepository.existsByIsbn(createBookRequestDto.getIsbn())) {
            throw new DataProcessingException("Book with such isbn "
                    + createBookRequestDto.getIsbn() + " already exist.");
        }
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
        return bookMapper.toDto(bookRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Can't find book by id:" + id)));
    }

    @Override
    public BookDto updateBookById(Long id, CreateBookRequestDto createBookRequestDto) {
        if (!bookRepository.existsById(id)) {
            throw new EntityNotFoundException("Can't update book by id:" + id);
        }
        Book book = bookMapper.toModel(createBookRequestDto);
        book.setId(id);
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public void deleteBookById(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new EntityNotFoundException("Can't delete book by id:" + id);
        }
        bookRepository.deleteById(id);

    }

    @Override
    public List<BookDto> search(BookSearchParametersDto params) {
        Specification<Book> bookSpecification = bookSpecificationBuilder.build(params);
        return bookRepository.findAll(bookSpecification)
                .stream()
                .map(bookMapper::toDto)
                .toList();
    }
}
