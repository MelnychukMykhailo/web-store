package online.books.webstore.repository.book;

import java.util.Arrays;
import online.books.webstore.model.Book;
import online.books.webstore.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class AuthorSpecificationProvider implements SpecificationProvider<Book> {
    private final String key = "author";

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public Specification<Book> getSpecification(String[] params) {
        return (root, query, criteriaBuilder) ->
                root.get(key).in(Arrays.stream(params).toArray());
    }
}
