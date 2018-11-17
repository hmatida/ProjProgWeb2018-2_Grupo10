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
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author hernanematida
 */

@Service
public class ToRentService {
    
    @Autowired
    private PersonRepo personRepo;
    
    @Autowired
    private MovieRepo movieRepo;
    
    @Autowired
    private RentMovieRepo rentMovieRepo;
    
    
    public ModelAndView rent(ModelAndView mod, String userName, Long idMovie){
        
        Calendar today = Calendar.getInstance();
        today.add(Calendar.DATE, 6);
        
        Person person = personRepo.findPersonByEmail(userName);
        Movie movie = movieRepo.findById(idMovie).get();
        
        RentMovie rMovie = new RentMovie();
        rMovie.setPerson(person);
        rMovie.setMovie(movie);
        rMovie.setIsPay(true);
        rMovie.setExpDate(today);
        
        rentMovieRepo.save(rMovie);
        
        String mensagem = "O filme "+movie.getName()+" alugado com sucesso!";
        
        mod.addObject("mensagem", mensagem);
        
        return mod;
    }
    
    public ModelAndView myMovies(ModelAndView mod, String userName){
        
        
        
        return mod;
    }
}
