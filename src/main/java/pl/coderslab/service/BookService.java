package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;
import pl.coderslab.repository.BookDao;

@Service
public class BookService {
    private final BookDao bookDao;

    public BookService(BookDao bookDao) {
        System.out.println("Asdasd");
        System.out.println("Asdasd");

        this.bookDao = bookDao;
    }

    public void saveBookFromService(Book book){
        bookDao.saveBook(book);
    }

}
