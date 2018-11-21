/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rentamovie.ram.model.services_and_utilities;

import br.com.rentamovie.ram.model.entities.Movie;
import br.com.rentamovie.ram.model.entities.Person;
import br.com.rentamovie.ram.model.entities.RentMovie;
import br.com.rentamovie.ram.model.repositories.MovieRepo;
import br.com.rentamovie.ram.model.repositories.PersonRepo;
import br.com.rentamovie.ram.model.repositories.RentMovieRepo;
import java.util.ArrayList;
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
        modelAndView.addObject("movies", movieRepo.findAll());  
        return preparePass(modelAndView, userName);
    }
    
    public ModelAndView movieById(ModelAndView modelAndView, Long idMovie, String userName){
        try {
            Movie movie = movieRepo.findById(idMovie).get();
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
        mod.addObject("userLoged", person);
        mod.addObject("moviesNumber", movies.toString());
        
        return mod;
    }
}
