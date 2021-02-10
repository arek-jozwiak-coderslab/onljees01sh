package pl.coderslab;

import pl.coderslab.model.Book;

public class BookValidator {

    public static boolean validateBook(Book book) {
        if (book.getTitle().length() < 1) {
            return false;
        }

        return true;
    }
}
