package com.epam.javacourse.homework3;

public class Bookstore {
    public void displayBooksByAuthorsFullName(String authorName, Book[] books) {
        for (Book book : books) {
            if (book.getAuthor().getFullName().equals(authorName)) {
                System.out.println(book);
            }
        }
    }
}
