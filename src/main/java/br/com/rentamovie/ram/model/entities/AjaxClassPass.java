/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rentamovie.ram.model.entities;

/**
 *
 * @author hernanematida
 */
public class AjaxClassPass {
    
    private Long id_movie;
    
    private String name;

    public AjaxClassPass(Long id_movie, String name) {
        this.id_movie = id_movie;
        this.name = name;
    }

    public Long getId_movie() {
        return id_movie;
    }

    public void setId_movie(Long id_movie) {
        this.id_movie = id_movie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
