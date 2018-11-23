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
 *Classe para serviços de Person.
 * Realiza o CRUD para Person.
 * @author hernanematida
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    /**
     * Retorna o form para cadastro de novo usuário.
     * Lança o objeto Person para ser validado quando o controller receber
     * o form com os dados.
     * @return ModelAndView
     */
    public ModelAndView novoForm(ModelAndView modelAndView) {
        Person person = new Person();
        modelAndView.addObject("person", person);
        return modelAndView;
    }

    /**
     * Veirica se existe um usuário com o mesmo e-mail já cadastrado no banco
     * de dados e o salva, caso não esteja cadastrado email.
     * @return ModelAndView
     */
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
    
    /**
     * Lança o objeto Person cujo id é passado como parâmetro na view de 
     * atualização de usuário logado.
     * @return ModelAndView
     */
    public ModelAndView getPersonById(ModelAndView mod, Long idPerson){
        Person p = personRepo.findById(idPerson).get();
        p.setPassword(null);
        mod.addObject("person", p);
        return mod;
    }

}
