package pl.coderslab.drink;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/drink")
public class DrinkController {


    private final DrinkDao drinkDao;

    public DrinkController(DrinkDao drinkDao) {
        this.drinkDao = drinkDao;
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("drink", new Drink());
        return "drink/form";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveProposition(@Valid Drink drink, BindingResult result) {
        if (result.hasErrors()) {
            return "drink/form";
        }
        // save person
        return "redirect:/drink/list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public String getAll(Model model) {
        model.addAttribute("drinks", drinkDao.getAll());
        return "drink/list";
    }


}
