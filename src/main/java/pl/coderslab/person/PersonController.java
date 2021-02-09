package pl.coderslab.person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.repository.PersonDao;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping("/show-form")
    public String showBookForm(Model model) {
        model.addAttribute("person", new Person());
        return "person/form";
    }

    @PostMapping("/show-form")
    public String personForm(Person person) {
        personDao.save(person);
        return "person/form";
    }

}
