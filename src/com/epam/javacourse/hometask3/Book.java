package com.epam.javacourse.hometask3;

import java.util.Arrays;
import java.util.Objects;

public final class Book extends Bookstore {
    private final String isbn;
    private final String name;
    private final Author authors;
    private final Publisher publisher;
    private final String publicationDate;
    private final boolean isPaperback;

    public Book(String isbn, String name, Author authors, Publisher publisher, String publicationDate,
                boolean isPaperback) {
        this.isbn = isbn;
        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.isPaperback = isPaperback;
    }

    public Author[] getAuthors() {
        return new Author[]{authors};
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", authors=" + Arrays.toString(new Author[]{authors}) +
                ", publisher=" + publisher +
                ", publicationDate='" + publicationDate + '\'' +
                ", isPaperback=" + isPaperback +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Book) obj;
        return Objects.equals(this.isbn, that.isbn) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.authors, that.authors) &&
                Objects.equals(this.publisher, that.publisher) &&
                Objects.equals(this.publicationDate, that.publicationDate) &&
                this.isPaperback == that.isPaperback;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, name, authors, publisher, publicationDate, isPaperback);
    }

}