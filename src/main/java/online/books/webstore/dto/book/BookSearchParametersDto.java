package online.books.webstore.dto.book;

public record BookSearchParametersDto(String[] titles, String[] authors, String[] isbns) {
}

