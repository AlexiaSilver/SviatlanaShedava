package com.epam.javacourse.hometask3;

public abstract class Bookstore {
    public static void displayBooksByAuthor(String authorName, Book[] books) {
        for (Book book : books) {
            for (Author author : book.getAuthors()) {
                if (author.getFullName().equals(authorName)) {
                    System.out.println(book);
                }
            }
        }
    }
}
