package online.books.webstore.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import online.books.webstore.model.Book;
import online.books.webstore.repository.BookRepository;
import online.books.webstore.service.BookService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
