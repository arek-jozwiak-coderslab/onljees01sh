package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;
import pl.coderslab.repository.BookDao;
import pl.coderslab.repository.PublisherDao;
import pl.coderslab.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;
    private final BookDao bookDao;
    private final PublisherDao publisherDao;

    public BookController(BookService bookService, BookDao bookDao, PublisherDao publisherDao) {
        this.bookService = bookService;
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
    }


    @ResponseBody
    @RequestMapping("/add")
    public String addBook() {

        Publisher publisher = new Publisher();
        publisher.setName("Helion");
        publisherDao.save(publisher);
        Book book = new Book();
        book.setPublisher(publisher);
        book.setTitle("Thinking in Java");
        book.setDescription("Very long book about java.");
        bookService.saveBookFromService(book);
        return "added";
    }


    @ResponseBody
    @RequestMapping("/edit")
    public String editBook() {
        Book book = bookDao.findById(1l);
        book.setTitle("Thinking in Java 2");
        book.setDescription("Very long book about java 2.");
        bookDao.update(book);
        return "edit";
    }
    @ResponseBody
    @RequestMapping("/delete")
    public String deleteBook() {
        Book book = bookDao.findById(1l);
        bookDao.delete(book);
        return "deleted";
    }

    @ResponseBody
    @RequestMapping("/get/{id}")
    public String getBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "deleted";
    }


}
