package br.com.rentamovie.ram;


import br.com.rentamovie.ram.model.entities.Genre;
import br.com.rentamovie.ram.model.entities.Movie;
import br.com.rentamovie.ram.model.repositories.GenreRepo;
import br.com.rentamovie.ram.model.repositories.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hernanematida
 */
public class Popula {
    
    @Autowired
    private MovieRepo movieRepo;
    
    @Autowired
    private GenreRepo genreRepo;
    
    public void addFilmes(){
        if (movieRepo.count() == 0){
            Movie mov1 = new Movie();
            mov1.setActors("");
            mov1.setDirector("");
        }
    }
    
    public void addGenre(){
        if (genreRepo.count() == 0){
            Genre genre = new Genre();
            genre.setName("Ação");
            genreRepo.save(genre);
            genre.setName("Animação");
            genreRepo.save(genre);
            genre.setName("Aventura");
            genreRepo.save(genre);
            genre.setName("Comédia");
            genreRepo.save(genre);
            genre.setName("Drama");
            genreRepo.save(genre);
            genre.setName("Ficção científica");
            genreRepo.save(genre);
            genre.setName("Romance");
            genreRepo.save(genre);
            genre.setName("Suspense");
            genreRepo.save(genre);
            genre.setName("Dança");
        }
    }
    
}
