package pl.coderslab.person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.model.Book;

@Controller
@RequestMapping("/person")
public class PersonController {

    @GetMapping("/show-form")
    public String showBookForm(Model model) {
        model.addAttribute("book", new Person());
        return "person/form";
    }

    @PostMapping("/show-form")
    public String personForm(Person person
    ) {

        return "person/form";
    }

}
