package online.books.webstore.repository.book;

import java.util.List;
import lombok.RequiredArgsConstructor;
import online.books.webstore.model.Book;
import online.books.webstore.repository.specification.SpecificationProvider;
import online.books.webstore.repository.specification.SpecificationProviderManager;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookSpecificationProviderManager implements SpecificationProviderManager<Book> {
    private final List<SpecificationProvider<Book>> bookSpecificationProviders;

    @Override
    public SpecificationProvider<Book> getSpecificationProvider(String key) {
        return bookSpecificationProviders.stream()
                .filter(b -> b.getKey().equals(key))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("Can't find correct specification provider for key "
                                + key));
    }
}
