package online.books.webstore;

import java.math.BigDecimal;
import online.books.webstore.model.Book;
import online.books.webstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebStoreApplication {
    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(WebStoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Book newBook = new Book();
                newBook.setTitle("Kobzar");
                newBook.setAuthor("Shevchenko");
                newBook.setIsbn("ds123");
                newBook.setPrice(BigDecimal.valueOf(12));

                bookService.save(newBook);

                System.out.println(bookService.findAll());
            }
        };
    }

}
