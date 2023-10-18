package online.books.webstore.service;

import java.util.List;
import online.books.webstore.model.Book;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();
}
