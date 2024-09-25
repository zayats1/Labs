package edu.bogdan.zaiats.lab2.main;

import edu.bogdan.zaiats.lab2.book.Book;

import java.util.List;

public class BookSelector {
    private List<Book> books;

    public BookSelector (List<Book> books) {
        this.books = books;
    }

    public BookSelector  withAuthor(String author) {
        this.books = this.books.stream().filter(book -> book.getAuthor().equals(author)).toList();
        return this;
    }

    public BookSelector  withPublicationYear(int year) {
        this.books = this.books.stream().filter(book -> book.getPublicationYear() == year).toList();
        return this;
    }

    public BookSelector  withPublishingHouse(String publishingHouse) {
        this.books  = this.books.stream().filter(book -> book.getPublishingHouse().equals(publishingHouse)).toList();
        return this;
    }

    public BookSelector withPageCount(int pageCount) {
        this.books = this.books.stream().filter(book -> book.getPageCount() == pageCount).toList();
        return this;
    }

    public List<Book> getBooks() {
        return this.books;
    }
}
