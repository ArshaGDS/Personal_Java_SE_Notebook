package com.arsha.fundamentals.functionalProgramming.streams;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class StreamsDemo {

    public static void main(String[] args) {

        Book[] books = new Book[] {
                new Book(1, "Book_1", new Author[] { new Author(1, "Jon", "Johnson") }, new Publisher(1, "Publisher_1"), 1990, 231, BigDecimal.valueOf(24.99), CoverType.PAPERBACK),

                new Book(2, "Book_2", new Author[] { new Author(1, "Jon", "Johnson"), new Author(2, "William", "Wilson") }, new Publisher(2, "Publisher_2"), 2000, 120, BigDecimal.valueOf(14.99), CoverType.PAPERBACK),

                new Book(3, "Book_3", new Author[] { new Author(3, "Walter", "Peterson") }, new Publisher(1, "Publisher_1"), 1997, 350, BigDecimal.valueOf(34.99), CoverType.HARDCOVER),

                new Book(4, "Book_4", new Author[] { new Author(4, "Craig", "Gregory") }, new Publisher(3, "Publisher_3"), 1992, 185, BigDecimal.valueOf(19.99), CoverType.PAPERBACK) };


        BookService bookService = new BookService();
        Book[] result1 = bookService.filterBooksByAuthor(
                new Author(1, "Jon", "Johnson"),
                books
        );

        System.out.println("filterBooksByAuthor:");
        System.out.println(Arrays.toString(result1));
        System.out.println("-------------------------");

        //-------------------------

        Book[] result2 = bookService.filterBooksByPublisher(
                new Publisher(1, "Publisher_1"),
                books
        );

        System.out.println("filterBooksByPublisher:");
        System.out.println(Arrays.toString(result2));
        System.out.println("-------------------------");

        //-------------------------

        Book[] result3 = bookService.filterBooksAfterSpecifiedYear(1997, books);

        System.out.println("filterBooksAfterSpecifiedYear:");
        System.out.println(Arrays.toString(result3));
    }

    //------------------------------------------------------------

    private static class Author {
        private final int id;
        private final String firstname;
        private final String lastname;

        public Author(int id, String firstname, String lastname) {
            this.id = id;
            this.firstname = firstname;
            this.lastname = lastname;
        }

        public int getId() {
            return id;
        }

        public String getFirstname() {
            return firstname;
        }

        public String getLastname() {
            return lastname;
        }

        @Override
        public String toString() {
            return "Author{" +
                    "id=" + id +
                    ", firstname='" + firstname + '\'' +
                    ", lastname='" + lastname + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) { return false; }
            if (obj instanceof Author author) {
                return this.id == author.getId() && this.firstname.equals(author.getFirstname()) && this.lastname.equals(author.getLastname());
            }

            return false;
        }
    }

    private static class Publisher {
        private final int id;
        private final String publisherName;

        public Publisher(int id, String publisherName) {
            this.id = id;
            this.publisherName = publisherName;
        }

        public int getId() {
            return id;
        }

        public String getPublisherName() {
            return publisherName;
        }

        @Override
        public String toString() {
            return "Publisher{" +
                    "id=" + id +
                    ", publisherName='" + publisherName + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) { return false; }
            if (obj instanceof Publisher publisher) {
                return this.id == publisher.id && this.publisherName.equals(publisher.publisherName);
            }
            return false;
        }
    }

    private enum CoverType {
        PAPERBACK, HARDCOVER
    }

    private static class Book {
        private final int id;
        private final String name;
        private final Author[] authors;
        private final Publisher publisher;
        private final int publishingYear;
        private final int amountOfPages;
        private final BigDecimal price;
        private final CoverType coverType;

        public Book(int id, String name, Author[] authors, Publisher publisher, int publishingYear, int amountOfPages, BigDecimal price, CoverType coverType) {
            this.id = id;
            this.name = name;
            this.authors = authors;
            this.publisher = publisher;
            this.publishingYear = publishingYear;
            this.amountOfPages = amountOfPages;
            this.price = price;
            this.coverType = coverType;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Author[] getAuthors() {
            return authors;
        }

        public Publisher getPublisher() {
            return publisher;
        }

        public int getPublishingYear() {
            return publishingYear;
        }

        public int getAmountOfPages() {
            return amountOfPages;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public CoverType getCoverType() {
            return coverType;
        }

        @Override
        public String toString() {
            return "Book{" + "\n" +
                    "id=" + id + "\n" +
                    ", name='" + name + '\'' + "\n" +
                    ", authors=" + Arrays.toString(authors) + "\n" +
                    ", publisher=" + publisher + "\n" +
                    ", publishingYear=" + publishingYear + "\n" +
                    ", amountOfPages=" + amountOfPages + "\n" +
                    ", price=" + price + "\n" +
                    ", coverType=" + coverType + "\n" +
                    '}' + "\n";
        }

        private boolean hasAuthor(Author author) {
            return Arrays.asList(authors).contains(author);
        }
    }

    private static class BookService {

        public Book[] filterBooksByAuthor(Author author, Book[] books) {
            return Arrays.stream(books)
                    .filter(Objects::nonNull)
                    .filter(book -> book.hasAuthor(author))
                    .toArray(Book[]::new);
        }

        public Book[] filterBooksByPublisher(Publisher publisher, Book[] books) {
            return Arrays.stream(books)
                    .filter(Objects::nonNull)
                    .filter(book -> book.publisher.equals(publisher))
                    .toArray(Book[]::new);
        }

        // methods keeps books with publishing year inclusively.
        public Book[] filterBooksAfterSpecifiedYear(int yearFromInclusively, Book[] books) {
            return Arrays.stream(books)
                    .filter(Objects::nonNull)
                    .filter(book -> book.getPublishingYear() == yearFromInclusively)
                    .toArray(Book[]::new);
        }
    }
}
