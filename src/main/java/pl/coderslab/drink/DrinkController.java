package pl.coderslab.drink;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
        drinkDao.save(drink);
        return "redirect:/drink/list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String showEditForm(@RequestParam long id, Model model) {
        model.addAttribute("drink", drinkDao.findById(id));
        return "drink/form";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveEditForm(@Valid Drink drink, BindingResult result) {
        if (result.hasErrors()) {
            return "drink/form";
        }
        drinkDao.update(drink);
        return "redirect:/drink/list";
    }

    @RequestMapping("/list")
    public String getAll(Model model) {
        model.addAttribute("drinks", drinkDao.getAll());
        return "drink/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam long id, Model model) {
        drinkDao.delete(drinkDao.findById(id));
        return "redirect:/drink/list";
    }


}
