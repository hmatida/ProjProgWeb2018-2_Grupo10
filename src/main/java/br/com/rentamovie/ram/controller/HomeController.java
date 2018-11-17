package br.com.rentamovie.ram.controller;

import br.com.rentamovie.ram.model.entities.Person;
import br.com.rentamovie.ram.model.services_and_utilities.MovieService;
import br.com.rentamovie.ram.model.services_and_utilities.PersonService;
import br.com.rentamovie.ram.model.services_and_utilities.ToRentService;
import javax.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
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
   
    private final ToRentService toRent;
    
    public HomeController(MovieService movieService, PersonService personService,
                            ToRentService toRent){
        this.movieService = movieService;
        this.personService = personService;
        this.toRent = toRent;
        
    }


    @GetMapping("/")
    public ModelAndView start() {
        ModelAndView mod = new ModelAndView("index");
        String userName =  SecurityContextHolder.getContext()
                .getAuthentication().getName();
        return movieService.operation(mod, userName);
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }
    
    @GetMapping("/novo")
    public ModelAndView newPersonPage() {
        ModelAndView mod = new ModelAndView("novo");
        return personService.novoForm(mod);
    }
    
    @GetMapping("/detalhe_filme/{idMovie}")
    public ModelAndView movieDetails(@PathVariable("idMovie")Long id_movie) {
        ModelAndView mod = new ModelAndView("detalhe_filme");
        
        String userName =  SecurityContextHolder.getContext()
                .getAuthentication().getName();
        
        return movieService.movieById(mod, id_movie, userName);
    }
    
    @GetMapping("/alugar/{idMovie}")
    public ModelAndView alugar(@PathVariable("idMovie") Long id_movie){
        ModelAndView mod = new ModelAndView("alugado");
        return toRent.rent(mod,SecurityContextHolder.getContext()
                .getAuthentication().getName(), id_movie);
    }

    @PostMapping("/save_person")
    public ModelAndView savePerson(@Valid Person person, BindingResult bindingResult) {
        ModelAndView mod = new ModelAndView("novo");
        return personService.salva(mod, person, bindingResult);
    }
}
