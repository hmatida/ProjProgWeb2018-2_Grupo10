/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rentamovie.ram.model.services_and_utilities;

import br.com.rentamovie.ram.model.repositories.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author hernanematida
 */
@Service
public class MovieService {
    
    @Autowired
    private MovieRepo movieRepo;

    
    public ModelAndView operation(ModelAndView modelAndView){
        System.out.println(movieRepo.count());
        modelAndView.addObject("movies", movieRepo.findAll());
        return modelAndView;
    }
}
