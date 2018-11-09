/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rentamovie.ram.model.repositories;

import br.com.rentamovie.ram.model.entities.Genre;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author hernanematida
 */
public interface GenreRepo extends CrudRepository<Genre, Long>{
    
}
