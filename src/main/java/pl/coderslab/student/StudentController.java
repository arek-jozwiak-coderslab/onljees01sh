package pl.coderslab.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @ModelAttribute(name = "programmingSkills")
    public List<String> getprogrammingSkills() {

        return List.of("Java", "MySQL", "JSP", "PHP", "RTV");
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/form";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addStudent(Student student) {
        StringBuilder sb = new StringBuilder();
        sb.append(student.getFirstName()).append("  : ").append(student.getLastName());
        sb.append(student.isMailingList() ? " yes" : " no");
        sb.append(" Skills: ");
        student.getProgrammingSkills().forEach(ps -> sb.append(ps).append(" "));
        return sb.toString();
    }

    @RequestMapping(value = "/simple", method = RequestMethod.GET)
    public String simple() {
        return "form/registerSimple";
    }


    @RequestMapping(value = "/simple", method = RequestMethod.POST)
    public String processSimple(@RequestParam String firstName,
                                @RequestParam String lastName, Model model) {
        Student student = new Student(firstName, lastName);
        model.addAttribute("student", student);
        return "form/success";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        Student student = new Student();
        student.setFirstName("arek");
        student.setLastName("jozwiak");
        model.addAttribute("student", student);
        return "form/register";
    }

    @PostMapping(value = "/register")
    public String processForm(Student student, @RequestParam String sss, Model model) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return "form/success";
    }

    @ModelAttribute(name = "strstr")
    public List<String> getSomeStrings() {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa");
        return List.of("aaaaa", "asdffsdfs");
    }
}
