package br.com.rentamovie.ram.controller;

import br.com.rentamovie.ram.model.entities.Person;
import br.com.rentamovie.ram.model.repositories.MovieRepo;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private MovieRepo movieRepo;

    @GetMapping("/")
    public ModelAndView start() {
        ModelAndView mod = new ModelAndView("index");
        return mod.addObject("movies", movieRepo.findAll());
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }
    
    @GetMapping("/novo")
    public ModelAndView novo() {
        return new ModelAndView("novo");
    }

    @PostMapping("/cadastra")
    public ModelAndView salva(@Valid Person person) {
        return new ModelAndView("novo");
    }
}
