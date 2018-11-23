/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rentamovie.ram.model.entities;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author hernanematida
 */

@Entity
public class RentMovie implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rent;
    
    @ManyToOne
    @JoinColumn(name = "id_person", referencedColumnName = "id_person")
    private Person person;
    
    @ManyToOne
    @JoinColumn(name = "id_movie", referencedColumnName = "id_movie")
    private Movie movie;
    
    private Calendar expDate;
    
    private boolean isPay;
    
    private boolean isOnRent = true;
    
    private int rating;

    public Long getId_rent() {
        return id_rent;
    }

    public void setId_rent(Long id_rent) {
        this.id_rent = id_rent;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Calendar getExpDate() {
        return expDate;
    }

    public void setExpDate(Calendar expDate) {
        this.expDate = expDate;
    }

    public boolean isIsPay() {
        return isPay;
    }

    public void setIsPay(boolean isPay) {
        this.isPay = isPay;
    }

    public boolean isIsOnRent() {
        return isOnRent;
    }

    public void setIsOnRent(boolean isOnRent) {
        this.isOnRent = isOnRent;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
    
    
}
