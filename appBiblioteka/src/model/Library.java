package model;

public class Library {
    private final int maxBooks = 1000;
    private Book[] books = new Book[maxBooks];
    private int booksNumber;

    public void addBook(Book book) {
        if (booksNumber < maxBooks) {
            books[booksNumber] = book;
            booksNumber++;
        } else {
            System.out.println("Maxymalna liczba ksiazek zostala osiagnieta");
        }
    }

    public void printBooks() {
        if (booksNumber == 0) {
            System.out.println("Brak ksiazek");
        }
        for (int i = 0; i < booksNumber; i++) {
            books[i].printInfo();
        }
    }
}



