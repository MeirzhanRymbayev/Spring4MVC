package com.websystique.springmvc.controller;
/*
http://websystique.com/springmvc/spring-4-mvc-form-validation-with-hibernate-jsr-validator-resource-handling-using-annotations/
*/
import com.websystique.springmvc.model.Pizza;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloWorldController {

    /*
    * This method will serve as default GET handler
    *
    * */
    @RequestMapping(method = RequestMethod.GET)
    public String newRegistration(ModelMap model) {
        Pizza pizza = new Pizza();
        model.addAttribute("student", pizza);
        return "enroll";
    }

    /*
    * This method will be called on form submission, handling POST
    * request
    * It also validates the user input
    */
    @RequestMapping(method = RequestMethod.POST)
    public String saveRegistration(@Valid Pizza pizza, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "enroll";
        }
        model.addAttribute("success", "Dear " + pizza.getFirstName() + " , your Registration completed successfully");
        return "success";
    }

    /*
    * Method used to populate the Section list in view.
    * Note that here you can call external systems to provide real data.
    */
    @ModelAttribute("sections")
    public List<String> initializeSections(){
        List<String> sections = new ArrayList<String>();
        sections.add("Graduate");
        sections.add("Post Graduate");
        sections.add("Research");
        return sections;
    }

    /*
    * Method used to populate the country list in view.
    * Note that here you can call external systems to provide real data.
    */
    @ModelAttribute("countries")
    public List<String> initializeCountries() {

        List<String> countries = new ArrayList<String>();
        countries.add("USA");
        countries.add("CANADA");
        countries.add("FRANCE");
        countries.add("GERMANY");
        countries.add("ITALY");
        countries.add("OTHER");
        return countries;
    }

    /*
     * Method used to populate the subjects list in view.
     * Note that here you can call external systems to provide real data.
     */
    @ModelAttribute("subjects")
    public List<String> initializeSubjects() {

        List<String> subjects = new ArrayList<String>();
        subjects.add("Physics");
        subjects.add("Chemistry");
        subjects.add("Life Science");
        subjects.add("Political Science");
        subjects.add("Computer Science");
        subjects.add("Mathmatics");
        return subjects;
    }
}
