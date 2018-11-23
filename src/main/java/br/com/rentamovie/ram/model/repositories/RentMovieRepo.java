/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rentamovie.ram.model.repositories;

import br.com.rentamovie.ram.model.entities.Person;
import br.com.rentamovie.ram.model.entities.RentMovie;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author hernanematida
 */
public interface RentMovieRepo extends CrudRepository<RentMovie, Long> {

    /**
     * Pesquisa no banco de dados todos os filmes alugados não expirados 
     * pelo usuário passado como parâmetro.
     * @return List RentMovie
     */
    @Query("SELECT mvs FROM RentMovie mvs WHERE mvs.person=:person and isOnRent=true ORDER BY mvs.expDate ASC")
    public List<RentMovie> moviesOnRentedByPersonOnTrue(@Param("person")Person person);
    
    
    /**
     * Pesquisa no banco de dados todos os filmes alugados expirados ou não
     * pelo usuário passado como parâmetro.
     * @return List RentMovie
     */
    @Query("SELECT mvs FROM RentMovie mvs WHERE mvs.person=:person ORDER BY mvs.expDate ASC")
    public List<RentMovie> allMoviesOnRentedByPerson(@Param("person")Person person);
}
