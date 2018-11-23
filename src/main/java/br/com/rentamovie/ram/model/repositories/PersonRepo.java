/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rentamovie.ram.model.repositories;

import br.com.rentamovie.ram.model.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author hernanematida
 */
public interface PersonRepo extends CrudRepository<Person, Long> {
    /**
     * Retorna o objeto Person com base no nome de login passado como
     * parâmetro.
     * @return Person
     */
    @Query("SELECT p FROM Person p WHERE p.email like :email")
    public Person findPersonByEmail(@Param("email") String email);
}
