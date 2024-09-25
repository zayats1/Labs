package edu.bogdan.zaiats.lab1.book;

/**
 * 5. Book: id, Назва, Автор, Видавництво, Рік видання, Кількість сторінок, Ціна.
 * Скласти масив об'єктів. Вивести:
 * a) список книг заданого автора;
 * b) список книг, що видані заданим видавництвом;
 * c) список книг, що випущені після заданого року.
 */
public class Book {
    private int bookId;
    private String author;
    private String name;
    private String publishingHouse;
    private int publicationYear;
    private int pageCount;

    public Book(int bookId, String author, String name, String publishingHouse, int publicationYear, int pageCount) {
        this.bookId = bookId;
        this.author = author;
        this.name = name;
        this.publishingHouse = publishingHouse;
        this.publicationYear = publicationYear;
        this.pageCount = pageCount;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", publicationYear=" + publicationYear +
                ", pageCount=" + pageCount +
                '}';
    }
}
