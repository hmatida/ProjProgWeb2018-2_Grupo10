package br.com.rentamovie.ram.controller;

import br.com.rentamovie.ram.model.entities.AjaxClassPass;
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
    
    private String userNameContext = "";
    
    public HomeController(MovieService movieService, PersonService personService,
                            ToRentService toRent){
        this.movieService = movieService;
        this.personService = personService;
        this.toRent = toRent;
        
    }

    /**
     *Retorna a view index com os dados dos filmes alugados e outros do header
     * atualizados.
     * @return ModelAndView.
     */
    @GetMapping("/")
    public ModelAndView start() {
        ModelAndView mod = new ModelAndView("index");
        this.userNameContext =  SecurityContextHolder.getContext()
                .getAuthentication().getName();
        return movieService.operation(mod, userNameContext);
    }
    
    /**
     * Retorna a view de login.
     * @return ModelAndView
     */
    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }
    
    /**
     * Retorna a view para cadastro de novo usuário.
     * Essa view é acessível a qualquer usuário mesmo não cadastrada no sistema.
     * Não requer login.
     * @return ModelAndView
    */
    @GetMapping("/novo")
    public ModelAndView newPersonPage() {
        ModelAndView mod = new ModelAndView("novo");
        return personService.novoForm(mod);
    }
    
    /**
     * Retorna a view com os objeto Movie pertinente ao parâmetro passado.
     * Requer login.
     * @return ModelAndView.
     */
    @GetMapping("/detalhe_filme/{idMovie}")
    public ModelAndView movieDetails(@PathVariable("idMovie")Long id_movie) {
        ModelAndView mod = new ModelAndView("detalhe_filme");
        
        return movieService.movieById(mod, id_movie, userNameContext);
    }
    
    /**
     * Retorna a view para atualização dos dados do usuário logado.
     * Requer login.
     * @return ModelAndView
    */
    @GetMapping("/modify_person/{idPerson}")
    public ModelAndView editPerson(@PathVariable("idPerson")Long id_person){
        ModelAndView mod = new ModelAndView("person_edit");
        mod = movieService.preparePass(mod, userNameContext);
        return personService.getPersonById(mod, id_person);
    }
    
    /**
     * Retorna a view dos detalhes do filme alugado.
     * Realiza o aluguel do filme escolhido
     * Requer login.
     * @return ModelAndView
    */
    @GetMapping("/alugar/{idMovie}")
    public ModelAndView alugar(@PathVariable("idMovie") Long id_movie){
        ModelAndView mod = new ModelAndView("alugado");
        mod = toRent.rent(mod,SecurityContextHolder.getContext()
                .getAuthentication().getName(), id_movie);
        return movieService.preparePass(mod, userNameContext);
    }
    
    /**
     * Retorna a view com todos os filmes alugados não expirados pelo usuário logado. 
     * Os filmes expirados não são mostrados, pois são filtrados pelo método.
     * Requer login.
     * @return ModelAndView
    */
    @GetMapping("/my_movies")
    public ModelAndView myMovies(){
        ModelAndView mod = new ModelAndView("alugado");
        mod=movieService.preparePass(mod, userNameContext);
        return toRent.myMovies(mod, userNameContext);
    }

    /**
     * Valida e salva no banco o form do novo usuário.
     * Não requer login.
     * @return ModelAndView
    */
    @PostMapping("/save_person")
    public ModelAndView savePerson(@Valid Person person, BindingResult bindingResult) {
        ModelAndView mod = new ModelAndView("novo");
        return personService.salva(mod, person, bindingResult);
    }
    
    /**
     * Valida e salva no banco o os novos dados no form do usuário logado.
     * Requer login.
     * @return ModelAndView
    */
    @PostMapping("/edit_person")
    public ModelAndView editPerson(@Valid Person person, BindingResult bindingResult) {
        ModelAndView mod = new ModelAndView("person_edit");
        mod = movieService.preparePass(mod, userNameContext);
        return personService.salva(mod, person, bindingResult);
    }
    
    /**
     * Retorna a view com os detalhes do filme pesquiado no header Search
     * Requer login.
     * @return ModelAndView
    */
    @PostMapping("/findmovie")
    public ModelAndView findMovie(AjaxClassPass pass){
        ModelAndView mod = new ModelAndView("detalhe_filme");
        mod = movieService.preparePass(mod, userNameContext);
        return movieService.movieById(mod, pass.getId_movie(), userNameContext);
    }
}
