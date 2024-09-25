package edu.bogdan.zaiats.lab2.main;

import edu.bogdan.zaiats.lab2.book.Book;

import java.util.List;

class Main {
    private static final BookSelector bookShelf = new BookSelector (List.of(
            new Book(8556210, "Dan Brown", "Angels and demons", "Morning", 2014, 625),
            new Book(4852142, "Dan Brown", "Davinci Code", "KFL", 2015, 645),
            new Book(4585545, "Dan Brown", "The Source", "KFL", 2016, 855),
            new Book(4456210, "Dan Brown", "The lost symbol", "KFL", 2016, 555),
            new Book(4455850, "Dan Brown", "Inferno", "KFL", 2018, 750)
    ));


    public static void main(String[] args) {
        for (var book : bookShelf.getBooks()){
            System.out.println(book.toString());
        }

        var selected = bookShelf.withPublicationYear(2018).getBooks();

        System.out.println("Selected");
        for (var book : selected) {
            System.out.println(book.toString());
        }

        var withDanBrown = bookShelf.withAuthor("Dan Brown").withPublishingHouse("Morning") .getBooks() ;

        for (var book : withDanBrown) {
            System.out.println(book.toString());
        }
    }
}