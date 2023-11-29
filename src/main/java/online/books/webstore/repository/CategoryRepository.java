package online.books.webstore.repository;

import java.util.List;
import online.books.webstore.model.Book;
import online.books.webstore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT b FROM Book b JOIN b.categories c WHERE c.id = :categoryId")
    List<Book> getBooksByCategoryId(@Param("categoryId") Long categoryId);
}
