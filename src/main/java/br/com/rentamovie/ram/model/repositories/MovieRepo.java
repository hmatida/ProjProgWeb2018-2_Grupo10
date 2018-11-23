/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rentamovie.ram.model.repositories;

import br.com.rentamovie.ram.model.entities.AjaxClassPass;
import br.com.rentamovie.ram.model.entities.Movie;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author hernanematida
 */
public interface MovieRepo extends CrudRepository<Movie, Long> {
    
    @Query("SELECT new br.com.rentamovie.ram.model.entities.AjaxClassPass(m.id_movie, m.name) FROM Movie m")
    public List<AjaxClassPass> moviesAjax();
}
