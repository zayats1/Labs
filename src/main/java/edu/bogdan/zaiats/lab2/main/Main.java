package edu.bogdan.zaiats.lab2.main;

import edu.bogdan.zaiats.lab2.book.Book;

import java.util.List;

class Main {
    private static final List<Book> bookShelf = List.of(
            new Book(8556210, "Dan Brown", "Angels and demons", "Morning", 2014, 625),
            new Book(4852142, "Dan Brown", "Davinci Code", "CFL", 2015, 645),
            new Book(4585545, "Dan Brown", "The Source", "CFL", 2016, 855),
            new Book(4456210, "Dan Brown", "The lost symbol", "CFL", 2016, 555),
            new Book(4455850, "Dan Brown", "Inferno", "CFL", 2018, 750),
            new Book(7474545, "Stephen King", "Pet Cemetery", "CFL", 2017, 750)
    );


    public static void main(String[] args) {
        for (var book : bookShelf){
            System.out.println(book.toString());
        }

        var selected = new BookSelector(bookShelf).withPublicationYear(2018).getBooks();

        System.out.println("Selected");
        for (var book : selected) {
            System.out.println(book.toString());
        }

        System.out.println("Selected with morning");
        var withDanBrown =  new BookSelector(bookShelf).withAuthor("Dan Brown").withPublishingHouse("Morning") .getBooks() ;

        for (var book : withDanBrown) {
            System.out.println(book.toString());
        }

        System.out.println("Books with 750 pages");
        var selectedWithPages = new BookSelector(bookShelf).withPageCount(750).getBooks();

        selectedWithPages.forEach(book -> System.out.println(book.toString()));

    }
}