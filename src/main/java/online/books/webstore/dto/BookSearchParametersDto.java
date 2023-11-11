package online.books.webstore.dto;

public record BookSearchParametersDto(String[] titles, String[] authors, String[] isbns) {
}

