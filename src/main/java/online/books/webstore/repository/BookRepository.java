package online.books.webstore.repository;

import java.util.List;
import online.books.webstore.model.Book;

public interface BookRepository {
    Book save(Book book);

    List<Book> findAll();

    Book getBookById(Long id);
}
