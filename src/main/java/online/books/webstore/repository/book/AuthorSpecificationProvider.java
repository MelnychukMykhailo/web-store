package online.books.webstore.repository.book;

import java.util.Arrays;
import online.books.webstore.model.Book;
import online.books.webstore.repository.specification.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class AuthorSpecificationProvider implements SpecificationProvider<Book> {
    public static final String KEY = "author";

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public Specification<Book> getSpecification(String[] params) {
        return (root, query, criteriaBuilder) ->
                root.get(KEY).in(Arrays.stream(params).toArray());
    }
}
