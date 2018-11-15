package br.com.rentamovie.ram.controller;

import br.com.rentamovie.ram.model.entities.Person;
import br.com.rentamovie.ram.model.services_and_utilities.MovieService;
import br.com.rentamovie.ram.model.services_and_utilities.PersonService;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    
    private final MovieService movieService;
    
    private final PersonService personService;
    
    public HomeController(MovieService movieService, PersonService personService){
        this.movieService = movieService;
        this.personService = personService;
    }


    @GetMapping("/")
    public ModelAndView start() {
        ModelAndView mod = new ModelAndView("index");
        return movieService.operation(mod);
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }
    
    @GetMapping("/novo")
    public ModelAndView newPersonPage() {
        return new ModelAndView("novo");
    }
    
    @GetMapping("/detalhe_filme/{idMovie}")
    public ModelAndView movieDetails(@PathVariable("idMovie")Long id_movie) {
        System.out.println("Tessteeee >>>>");
        ModelAndView mod = new ModelAndView("detalhe_filme");
        return movieService.movieById(mod, id_movie);
    }

    @PostMapping("/save_person")
    public ModelAndView savePerson(@Valid Person person, BindingResult bindingResult) {
        return new ModelAndView("novo");
    }
}
