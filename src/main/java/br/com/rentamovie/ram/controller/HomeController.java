package br.com.rentamovie.ram.controller;

import br.com.rentamovie.ram.model.entities.Movie;
import br.com.rentamovie.ram.model.repositories.MovieRepo;
import br.com.rentamovie.ram.model.services_and_utilities.MovieService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    
    @Autowired
    private MovieRepo movieRepo;

    @GetMapping("/")
    public ModelAndView start(){
        ModelAndView mod = new ModelAndView("index");
           return mod.addObject("movies", movieRepo.findAll());
    }
    
    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }
}
