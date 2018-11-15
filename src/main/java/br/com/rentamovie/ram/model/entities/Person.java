package br.com.rentamovie.ram.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Calendar;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "person")
public class Person implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_person;

    @Column(length = 80, unique = false, nullable = false)
    @NotBlank(message = "Primeiro nome não pode ficar em branco.")
    private String name;

    @Column(length = 80, unique = false, nullable = false)
    @NotBlank(message = "Sobrenome não pode ficar em branco.")
    private String lastName;

    @NotBlank(message = "Data de nascimento é obrigaório.")
    private Calendar birthday;

    @Column(length = 11, unique = true, nullable = false)
//    @CPF(message = "CPF inválido")
    private String cpf;

    @Column(length = 100, unique = true, nullable = false)
    @NotBlank(message = "E-mail é obrigatório.")
    private String email;

    @Column(length = 100, unique = false, nullable = false)
//    @Min(value = 6, message = "A senha não pode ser menor do que 6 dígitos.")
    @NotBlank(message = "A senha é obrigatório.")
    private String password;

    private boolean isActive = true;
    
    private ProfileEnum profile;

    public Long getId_person() {
        return id_person;
    }

    public void setId_person(Long id_person) {
        this.id_person = id_person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public ProfileEnum getProfile() {
        return profile;
    }

    public void setProfile(ProfileEnum profile) {
        this.profile = profile;
    }
    
}
