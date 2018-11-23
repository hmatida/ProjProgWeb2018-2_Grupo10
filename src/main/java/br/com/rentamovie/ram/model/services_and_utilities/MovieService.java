/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rentamovie.ram.model.services_and_utilities;

import br.com.rentamovie.ram.model.entities.AjaxClassPass;
import br.com.rentamovie.ram.model.entities.Movie;
import br.com.rentamovie.ram.model.entities.Person;
import br.com.rentamovie.ram.model.entities.RentMovie;
import br.com.rentamovie.ram.model.repositories.MovieRepo;
import br.com.rentamovie.ram.model.repositories.PersonRepo;
import br.com.rentamovie.ram.model.repositories.RentMovieRepo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author hernanematida
 */
@Service
public class MovieService{
    
    @Autowired
    private MovieRepo movieRepo;
    
    @Autowired
    private PersonRepo personRepo;
    
    @Autowired
    private RentMovieRepo rentMovieRepo;
    
    public ModelAndView operation(ModelAndView modelAndView, String userName){
        this.verifyMovies(userName);
        modelAndView.addObject("movies", movieRepo.findAll());  
        return preparePass(modelAndView, userName);
    }
    
    public ModelAndView movieById(ModelAndView modelAndView, Long idMovie, String userName){
        try {
            Movie movie = movieRepo.findById(idMovie).get();
            System.out.println(movie.getGenre().getName());
            modelAndView.addObject("movie", movie);
        } catch (Exception e) {
            String erro = "Não foi possível localizar o filme";
            System.out.println(e);
            modelAndView.addObject("erro", erro);
        }
        
        return preparePass(modelAndView, userName);
    }
    
    public ModelAndView preparePass(ModelAndView mod, String userName){
        
        Person person  = personRepo.findPersonByEmail(userName);
        List<RentMovie> rentMovies = new ArrayList<>();
        rentMovies.addAll(rentMovieRepo.moviesOnRentedByPersonOnTrue(person));
       
        Integer movies = 0;
        
        if (!rentMovies.isEmpty()){
            movies = rentMovies.size();
        }
        
        AjaxClassPass pass = new AjaxClassPass(null, null);
        mod.addObject("userLoged", person);
        mod.addObject("moviesNumber", movies.toString());
        mod.addObject("moviesFilter", movieRepo.moviesAjax());
        mod.addObject("pass", pass);
        return mod;
    }
    
    public List<AjaxClassPass> moviesAjax(){
        return movieRepo.moviesAjax();
    }
    
    private void verifyMovies(String userName){
        Calendar now = Calendar.getInstance();
        Person p = personRepo.findPersonByEmail(userName);
        List<RentMovie> rmvs = new ArrayList<>();
        rmvs.addAll(rentMovieRepo.allMoviesOnRentedByPerson(p));
        for (int i =0; i<rmvs.size(); i++){
            if (rmvs.get(i).getExpDate().before(now) && rmvs.get(i).isIsOnRent()){
                rmvs.get(i).setIsOnRent(false);
                rentMovieRepo.save(rmvs.get(i));
            }
        }
    }
}
