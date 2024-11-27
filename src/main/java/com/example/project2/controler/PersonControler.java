package com.example.project2.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project2.Entity.CommandEntity;
import com.example.project2.Entity.PersonEntity;
import com.example.project2.service.PersonService;

@RestController
public class PersonControler {

    private final PersonService personService;

    public PersonControler(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/persons/")
    public PersonEntity createPerson(@RequestBody PersonEntity person) {
        return personService.createPerson(person);
    }

    @GetMapping("/persons/")
    public List<PersonEntity> getPersons() {
        return personService.getPersons();
    }

    @GetMapping("/persons/{id}")
    public Optional<PersonEntity> getPerson(@PathVariable Long id) {
        return Optional.of(personService.getPerson(id)).orElseThrow();
    }

    //problem cohesion
    @PostMapping("/commands/")
    public CommandEntity createCommand(@RequestBody CommandEntity command) {
        return personService.createCommand(command);
    }

    //problem cohesion
    @GetMapping("/commands/")
    public List<CommandEntity> getCommands() {
        return personService.getCommands();
    }

    //problem cohesion
    @GetMapping("/commands/{id}")
    public Optional<CommandEntity> getCommand(@PathVariable Long id) {
        return Optional.of(personService.getCommand(id)).orElseThrow();
    }
}
