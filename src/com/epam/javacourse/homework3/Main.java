package com.epam.javacourse.homework3;

public class Main {
    public static void main(String[] args) {
        Book[] books = new Book[3];
        books[0] = new Book("978-8172344304", "Pride and Prejudice", new Author("Jane", "Austen"), new Publisher(1, "Bantam Classics", "New York, USA, 10019"), "May 28, 2015", false);
        books[1] = new Book("978-0449912515", "Spark of Life", new Author("Erich", "Maria Remarque"), new Publisher(2, "Appleton-Century-Crofts", "Hutchinson, UK, 1620-81"), "April 10, 1952", false);
        books[2] = new Book("965-0485912335", "Perfume: The Story of a Murderer", new Author("Patrick", "Süskind"), new Publisher(3, "Diogenes Verlag", "Zürich, Switzerland, 8032"), "August 1, 2008", true);

        new Bookstore().displayBooksByAuthorsFullName("Erich Maria Remarque", books);
    }
}
