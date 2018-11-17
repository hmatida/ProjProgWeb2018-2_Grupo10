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

    @Query("SELECT mvs FROM RentMovie mvs WHERE mvs.person=:person ORDER BY mvs.expDate ASC")
    public List<RentMovie> moviesOnRentedByPerson(@Param("person")Person person);
}
