/**
 * Represents a book in the library.
 */
public class Book {
    /** The title of the book. */
    String title;
    /** The author of the book. */
    String author;
    /** The release date of the book. */
    int releaseDate;
    /** The number of pages in the book. */
    int pages;
    /** The publisher of the book. */
    String publisher;
    /** The ISBN of the book. */
    String isbn;

    /**
     * Gets the title of the book.
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     * @param title The title of the book.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the author of the book.
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the book.
     * @param author The author of the book.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the release date of the book.
     * @return The release date of the book.
     */
    public int getReleaseDate() {
        return releaseDate;
    }

    /**
     * Sets the release date of the book.
     * @param releaseDate The release date of the book.
     */
    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * Gets the number of pages in the book.
     * @return The number of pages in the book.
     */
    public int getPages() {
        return pages;
    }

    /**
     * Sets the number of pages in the book.
     * @param pages The number of pages in the book.
     */
    public void setPages(int pages) {
        this.pages = pages;
    }

    /**
     * Gets the publisher of the book.
     * @return The publisher of the book.
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Sets the publisher of the book.
     * @param publisher The publisher of the book.
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Gets the ISBN of the book.
     * @return The ISBN of the book.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets the ISBN of the book.
     * @param isbn The ISBN of the book.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Creates a new Book object with the given parameters.
     * @param title The title of the book.
     * @param author The author of the book.
     * @param releaseDate The release date of the book.
     * @param pages The number of pages in the book.
     * @param publisher The publisher of the book.
     * @param isbn The ISBN of the book.
     */
    public Book(String title, String author, int releaseDate,
                int pages, String publisher, String isbn) {
        this(title, author, releaseDate, pages, publisher);
        this.isbn = isbn;
    }

    /**
     * Creates a new Book object with the given parameters.
     * @param title The title of the book.
     * @param author The author of the book.
     * @param releaseDate The release date of the book.
     * @param pages The number of pages in the book.
     * @param publisher The publisher of the book.
     */
    public Book(String title, String author, int releaseDate, int pages, String publisher) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.pages = pages;
        this.publisher = publisher;
    }

    /**
     * Prints information about the book to the console.
     */
    void printInfo() {
        String info = title + "; " + author + "; " + releaseDate + "; "
                + pages + "; " + publisher;
        if(isbn!=null){
            info=info+";"+isbn;
        }
        System.out.println(info);
    }
}
