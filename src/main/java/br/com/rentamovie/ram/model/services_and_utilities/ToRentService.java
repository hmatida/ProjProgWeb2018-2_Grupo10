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
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

/**
 *Classe de para aluguel de filme pelo usuário cadastrado.
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
    
    /**
     * Método que realiza o aluguel do filme conforme o usuário, film e
     * view repassado por parâmetro.
     * @return ModelAndView.
     */
    public ModelAndView rent(ModelAndView mod, String userName, Long idMovie){
        
        Person person = personRepo.findPersonByEmail(userName);
        Movie movie = movieRepo.findById(idMovie).get();
        
        List<RentMovie> moviesRent = new ArrayList<>();
        moviesRent.addAll(rentMovieRepo.moviesOnRentedByPersonOnTrue(person));

        Calendar today = Calendar.getInstance();
        today.add(Calendar.DATE, 6);
        
        RentMovie rMovie = new RentMovie();
        rMovie.setPerson(person);
        rMovie.setMovie(movie);
        rMovie.setIsPay(true);
        rMovie.setExpDate(today);
        
        rentMovieRepo.save(rMovie);
        
        String mensagem = "O filme "+movie.getName()+" alugado com sucesso!";
        mod.addObject("mensagem", mensagem);
        mod.addObject("movies", rentMovieRepo.moviesOnRentedByPersonOnTrue(person));
        return mod;
    }
    
    /**
     * Método que busca os filmes alugados dado o usuário passado por parâmetro.
     * Inclui na view uma List com os Movies referentes ao usuário.
     * @return ModelAndView.
     */
    public ModelAndView myMovies(ModelAndView mod, String userName){
        List<RentMovie> moviesRented = new ArrayList<>();
        Person person = personRepo.findPersonByEmail(userName);
        moviesRented.addAll(rentMovieRepo.moviesOnRentedByPersonOnTrue(person));
        
        if(moviesRented.isEmpty()){
            String mensagem1 = "Ainda não existem filmes alugados!";
            mod.addObject("erro", mensagem1);
        } else {
            mod.addObject("movies", moviesRented);
        }
        return mod;
    }
}
