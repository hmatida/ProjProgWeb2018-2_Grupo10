/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rentamovie.ram.model.repositories;

import br.com.rentamovie.ram.model.entities.Genre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author hernanematida
 */
public interface GenreRepo extends CrudRepository<Genre, Long>{
    
    /**
     * Retorna o objeto Genre referente ao nome do Genre passado
     * como parâmetro.
     * @return Genre.
     */
    @Query("SELECT g FROM Genre g WHERE g.name like :nome")
    public Genre findGenreByName(@Param("nome")String name);
    
}
