package app;

import io.DataReader;
import model.Book;


public class Library {
    public static void main(String[] args) {

        final String appName = "Biblioteka ver 0.8";
        Book[] books = new Book[1000];
        DataReader dataReader = new DataReader();

        System.out.println(appName);
        System.out.println("Wprowadz nowa ksiazke");

        books[0] = dataReader.readAndCreateBook();
        books[1] = dataReader.readAndCreateBook();
        books[2] = dataReader.readAndCreateBook();

        dataReader.close();
        books[0].printInfo();
        books[1].printInfo();
        books[2].printInfo();

        System.out.println("System moze przechowywac do " + books.length + " ksiazek");
    }
}
