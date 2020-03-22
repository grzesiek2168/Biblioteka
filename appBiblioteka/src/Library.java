public class Library {
    public static void main(String[] args) {

        final String appName = "Biblioteka ver 0.3";
        Book[] books = new Book[1000];
        books[0] = new Book("W pustyni i w puszczy", "Henryk Sienkiewicz", 2010, 458, "Greg", "9788373271890");
        books[1] = new Book("Java. Efektywne programowanie. Wydanie II", "Joshua Bloch", 2009, 352, "Helion",
                "9788324620845");
        books[2] = new Book("SCJP Sun Certified Programmer for Java 8 Study Guide", "Bert Bates, Katherine Sierra",
                2008, 851, "McGraw-Hill Osborne Media", "9780071591065");

        System.out.println(appName);
        System.out.println("Ksiazki dostepne w bibliotece");
        books[0].printInfo();
        books[1].printInfo();
        books[2].printInfo();
        System.out.println("System moze przechowywac do " + books.length + " ksiazek");
    }
}
