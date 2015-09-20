package com.sankholin.web.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import com.sankholin.core.model.Car;
import com.sankholin.core.service.ICarService;

@Controller
public class CarController {

    @Autowired
    private Validator validator;

    @Autowired
    private ICarService iCarService;

    //space1

    @RequestMapping("/hi")
    @ResponseBody
    public String hi() {
        return "Hi, world.";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("message", "Spring MVC Hello World");
        return "home";
    }

    @RequestMapping("/car")
    public String car(Model model) {
        List<Car> carList = iCarService.findAll();
        model.addAttribute("carList", carList);
        return "car/carHome";
    }

    @RequestMapping("/car/list")
    public String carList(Model model) {
        List<Car> carList = iCarService.findAll();
        model.addAttribute("carList", carList);
        return "car/list";
    }

    @RequestMapping(value = "/car/add")
    public String carAdd() {
        return "car/add";
    }

    @RequestMapping(value = "/car/add", method = RequestMethod.POST)
    public String carAddSubmit(@ModelAttribute("car") @Valid Car car, BindingResult result) {

        // Read http://docs.spring.io/spring/docs/current/spring-framework-reference/html/validation.html#validation-beanvalidation-spring
        Set<ConstraintViolation<Car>> violations = validator.validate(car);
        for (ConstraintViolation<Car> violation : violations) {
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            // Add JSR-303 errors to BindingResult
            // This allows Spring to display them in view via a FieldError
            result.addError(new FieldError("car", propertyPath, "Invalid " + propertyPath + "(" + message + ")"));
        }

        if (result.hasErrors()) {
            return "car/add";
        }

        iCarService.add(car);
        return "redirect:/car/list";
    }

    @RequestMapping(value = "/carvelo", method = RequestMethod.GET)
    public String carvelo(Model model) {
        List<Car> list = iCarService.findAll();
        model.addAttribute("cars", list);
        return "carvelo";
    }

    @RequestMapping(value = "/carfm", method = RequestMethod.GET)
    public String carfm(@ModelAttribute("model") ModelMap model) {
        List<Car> carList = iCarService.findAll();
        model.addAttribute("carList", carList);
        return "carfm";
    }

    @RequestMapping(value = "/fmlayout", method = RequestMethod.GET)
    public String fmlayout(ModelMap model) {
        model.addAttribute("message", "Knock, knock, anyone there!");
        return "fmlayout";
    }

    //space2

    @RequestMapping("/xslview")
    public String xslview(Model model) throws Exception {

        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element root = document.createElement("wordList");

        List<String> words = Arrays.asList("Hello", "Spring", "Framework");
        for (String word : words) {
            Element wordNode = document.createElement("word");
            Text textNode = document.createTextNode(word);
            wordNode.appendChild(textNode);
            root.appendChild(wordNode);
        }

        model.addAttribute("wordList", root);
        return "xslview";
    }

    @RequestMapping("/employee")
    public ModelAndView employee() throws Exception {
        Resource resource = new ClassPathResource("citizens.xml");
        ModelAndView model = new ModelAndView("employee");
        model.addObject("xmlSource", resource);
        return model;
    }

    //space3

    @RequestMapping("/cover")
    public String cover(ModelMap model) {
        model.addAttribute("title", "Cover Page - Bootstrap");
        return "cover";
    }

    @RequestMapping("/theme")
    public String theme(ModelMap model) {
        model.addAttribute("title", "Theme Page - Bootstrap");
        return "theme";
    }

    @RequestMapping(value = {"/admin", "/admin/dashboard"})
    public String dashboard(ModelMap model) {
        model.addAttribute("title", "Dashboard - Bootstrap");
        return "admin/dashboard";
    }

    //space4

    @RequestMapping("/thyme")
    public String thyme(ModelMap model) {
        model.addAttribute("title", "Online - Thymeleaf");
        model.addAttribute("message", "Welcome to Thymeleaf");
        return "thyme";
    }

    @RequestMapping("/blog")
    public String blog(ModelMap model) {
        model.addAttribute("title", "Blog Home");
        return "blog";
    }

    @RequestMapping("/thycars")
    public String thycars(ModelMap model) {
        model.addAttribute("title", "ThyCars");
        return "thycars";
    }

    //common model attribute

    @ModelAttribute("carList")
    private List<Car> getCarList() {
        return iCarService.findAll();
    }

}
