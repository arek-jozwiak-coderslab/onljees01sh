package pl.coderslab.drink;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/drinkrepo")
public class DrinkRepoController {

    private final DrinkRepository drinkRepository;

    public DrinkRepoController(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    @RequestMapping("/list")
    @ResponseBody
    public String getAll() {
        List<Drink> all = drinkRepository.findAll();

        Drink drink = drinkRepository.findById(1l).orElse(new Drink());

        all.forEach(d -> System.out.println(d.getName() + " "));
        return "result";
    }
}
