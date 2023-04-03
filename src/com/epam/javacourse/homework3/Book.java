package com.epam.javacourse.homework3;

import java.util.Objects;

public class Book {
    private String isbn;
    private String name;
    private Author author;
    private Publisher publisher;
    private String publicationDate;
    private boolean isPaperback;

    public Book(String isbn, String name, Author author, Publisher publisher, String publicationDate,
                boolean isPaperback) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.isPaperback = isPaperback;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public boolean isPaperback() {
        return isPaperback;
    }

    public void setPaperback(boolean paperback) {
        isPaperback = paperback;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                "}, " + author.toString() +
                ", " + publisher.toString() +
                ", publicationDate={" + publicationDate + '}' +
                ", isPaperback=" + isPaperback +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Book that = (Book) obj;
        return Objects.equals(this.isbn, that.isbn) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.author, that.author) &&
                Objects.equals(this.publisher, that.publisher) &&
                Objects.equals(this.publicationDate, that.publicationDate) &&
                this.isPaperback == that.isPaperback;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, name, author, publisher, publicationDate, isPaperback);
    }
}
