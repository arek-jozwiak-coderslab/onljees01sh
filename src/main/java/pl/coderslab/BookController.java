package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @ResponseBody
    @RequestMapping("/add")
    public String addBook(){
        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setDescription("Very long book about java.");
        bookService.saveBookFromService(book);

        return "added";
    }

}
