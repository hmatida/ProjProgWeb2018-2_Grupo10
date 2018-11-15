/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rentamovie.ram.model.services_and_utilities;

import br.com.rentamovie.ram.model.entities.Movie;
import br.com.rentamovie.ram.model.repositories.MovieRepo;
import java.lang.annotation.Annotation;
import java.util.Optional;
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
    
    public ModelAndView operation(ModelAndView modelAndView){
        System.out.println(movieRepo.count());
        modelAndView.addObject("movies", movieRepo.findAll());
        return modelAndView;
    }
    
    public ModelAndView movieById(ModelAndView modelAndView, Long idMovie){
        try {
            Movie movie = movieRepo.findById(idMovie).get();
            modelAndView.addObject("movie", movie);
        } catch (Exception e) {
            String erro = "Não foi possível localizar o filme";
            System.out.println(e);
            modelAndView.addObject("erro", erro);
        }
        
        return modelAndView;
    }
}
