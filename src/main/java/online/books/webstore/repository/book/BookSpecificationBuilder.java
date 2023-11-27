package online.books.webstore.repository.book;

import lombok.RequiredArgsConstructor;
import online.books.webstore.dto.book.BookSearchParametersDto;
import online.books.webstore.model.Book;
import online.books.webstore.repository.specification.SpecificationBuilder;
import online.books.webstore.repository.specification.SpecificationProviderManager;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookSpecificationBuilder implements SpecificationBuilder<Book> {
    private final SpecificationProviderManager<Book> bookSpecificationProviderManager;

    @Override
    public Specification<Book> build(BookSearchParametersDto searchParameters) {
        Specification<Book> specification = Specification.where(null);
        if (searchParameters.titles() != null && searchParameters.titles().length > 0) {
            specification = specification.and(bookSpecificationProviderManager
                    .getSpecificationProvider(TitleSpecificationProvider.KEY)
                    .getSpecification(searchParameters.titles()));
        }
        if (searchParameters.authors() != null && searchParameters.authors().length > 0) {
            specification = specification.and(bookSpecificationProviderManager
                    .getSpecificationProvider(AuthorSpecificationProvider.KEY)
                    .getSpecification(searchParameters.authors()));
        }
        if (searchParameters.isbns() != null && searchParameters.isbns().length > 0) {
            specification = specification.and(bookSpecificationProviderManager
                    .getSpecificationProvider(IsbnSpecificationProvider.KEY)
                    .getSpecification(searchParameters.isbns()));
        }
        return specification;
    }
}
