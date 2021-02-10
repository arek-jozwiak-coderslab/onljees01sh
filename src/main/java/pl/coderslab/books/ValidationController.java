package pl.coderslab.books;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class ValidationController {

    private final Validator validation;

    public ValidationController(Validator validation) {
        this.validation = validation;
    }


    @ResponseBody
    @RequestMapping("/validate")
    public String validateTest() {

        Book book = new Book();
        Set<ConstraintViolation<Book>> validate = validation.validate(book);

        validate.forEach(
                cs -> System.out.println(cs.getPropertyPath() + " : " + cs.getMessage())
        );

        return "dddd";
    }
}
