package app;

import model.Book;
import io.DataReader;
import model.Library;

public class LibraryControl {
    private final int exit = 0;
    private final int addBook = 1;
    private final int printBooks = 2;

    private DataReader dataReader = new DataReader();
    private Library library = new Library();

    public void controlLoop() {
        int option;
        do {
            printOption();
            option = dataReader.getInt();

            switch (option) {
                case addBook:
                    addBook();
                    break;
                case printBooks:
                    printBooks();
                    break;
                case exit:
                    exit();
                    break;
                default:
                    System.out.println("Brak takiej opcji wprowadz ponownie");
            }

        } while (option != exit);
    }

    private void printOption() {
        System.out.println("Wybierz opcje");
        System.out.println(exit + "- Wyjscie z aplikacji");
        System.out.println(addBook + "- Dodanie ksiazki");
        System.out.println(printBooks + "- Wyswietl dostepne ksiazki");
    }

    private void addBook() {
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }

    private void printBooks() {
        library.printBooks();
    }

    private void exit() {
        System.out.println("Koniec pa pa");
    }

}
