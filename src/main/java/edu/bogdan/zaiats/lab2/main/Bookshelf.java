package edu.bogdan.zaiats.lab2.main;

import edu.bogdan.zaiats.lab2.book.Book;

import java.util.List;

public class Bookshelf {
    private List<Book> books;

    public Bookshelf(List<Book> books) {
        this.books = books;
    }

    public Bookshelf withAuthor(String author) {
        this.books = this.books.stream().filter(book -> book.getAuthor().equals(author)).toList();
        return this;
    }

    public Bookshelf withPublicationYear(int year) {
        this.books = this.books.stream().filter(book -> book.getPublicationYear() == year).toList();
        return this;
    }

    public Bookshelf withPublishingHouse(String publishingHouse) {
        this.books  = this.books.stream().filter(book -> book.getPublishingHouse().equals(publishingHouse)).toList();
        return this;
    }

    public Bookshelf withPageCount(int pageCount) {
        this.books = this.books.stream().filter(book -> book.getPageCount() == pageCount).toList();
        return this;
    }
}
