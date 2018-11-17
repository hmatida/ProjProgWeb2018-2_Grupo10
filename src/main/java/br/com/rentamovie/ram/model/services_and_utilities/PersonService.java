/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rentamovie.ram.model.services_and_utilities;

import br.com.rentamovie.ram.model.entities.Person;
import br.com.rentamovie.ram.model.repositories.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author hernanematida
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ModelAndView novoForm(ModelAndView modelAndView) {
        Person person = new Person();
        modelAndView.addObject("person", person);
        return modelAndView;
    }

    public ModelAndView salva(ModelAndView modelAndView, Person person,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("person", person);
        } else if (personRepo.findPersonByEmail(person.getEmail()) != null && person.getId_person() == null) {
            String erro = "Esse e-mail já está sendo usado por outro usuário.";
            modelAndView.addObject("person", person);
            modelAndView.addObject("erro", erro);
        } else {
            try {
                person.setPassword(passwordEncoder.encode(person.getPassword()));
                personRepo.save(person);
                String success = "Usuário " + person.getName() + " salvo com sucesso!";
                modelAndView.addObject("success", success);
            } catch (Exception e) {
                String erro = "Erro ao salvar usuário.";
                modelAndView.addObject("erro", erro);
                modelAndView.addObject("person", person);
            }
        }
        return modelAndView;
    }
    
    public ModelAndView getPersonById(ModelAndView mod, Long idPerson){
        Person p = personRepo.findById(idPerson).get();
        p.setPassword(null);
        mod.addObject("person", p);
        return mod;
    }

}
