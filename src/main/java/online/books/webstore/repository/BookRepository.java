package online.books.webstore.repository;

import online.books.webstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book getBookById(Long id);

    boolean existsById(Long id);
}
