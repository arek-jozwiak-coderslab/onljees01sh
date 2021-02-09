package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;
import pl.coderslab.repository.AuthorDao;
import pl.coderslab.repository.BookDao;
import pl.coderslab.repository.PublisherDao;
import pl.coderslab.service.BookService;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    public BookController(BookService bookService, BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookService = bookService;
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @ResponseBody
    @RequestMapping("/test")
    public String testBook() {
        List<Book> allWithAtLeastOnePublisher = bookDao.getAllWithAtLeastOnePublisher();
        System.out.println(allWithAtLeastOnePublisher.size());

        Publisher byId = publisherDao.findById(1l);
        List<Book> allForPublisher = bookDao.getAllForPublisher(byId);
        allForPublisher.forEach(b -> System.out.println(b));
        return "test";
    }
    @GetMapping("/show-form")
    public String showBookForm(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("publishers", publisherDao.getAll());
        return "book/form";
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
    @RequestMapping("/add-many")
    public String addManyBook() {
        Book book = new Book();
        Author byId = authorDao.findById(1l);
        Author byId2 = authorDao.findById(2l);
        List<Author> list = List.of(byId, byId2);
        book.setAuthors(list);

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

    @ResponseBody
    @RequestMapping("/all")
    public String getAllBook() {
        bookDao.getAll().forEach(b ->
                System.out.println(b.getTitle()));
        return "deleted";
    }


}
