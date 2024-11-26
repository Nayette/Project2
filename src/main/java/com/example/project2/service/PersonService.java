package com.example.project2.service;

import com.example.project2.Entity.CommandEntity;
import com.example.project2.Entity.PersonEntity;
import com.example.project2.repository.CommandRepository;
import com.example.project2.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final CommandRepository commandRepository;

    public PersonService(PersonRepository personRepository, CommandRepository commandRepository) {
        this.personRepository = personRepository;
        this.commandRepository = commandRepository;
    }

    public PersonEntity createPerson(PersonEntity person) {
        return personRepository.save(person);
    }

    public List<PersonEntity> getPersons() {
        return personRepository.findAll();
    }

    public Optional<PersonEntity> getPerson(Long id) {
        return Optional.of(personRepository.findById(id)).orElseThrow();
    }

    public CommandEntity createCommand(CommandEntity command) {
        return commandRepository.save(command);
    }

    public Optional<CommandEntity> getCommand(Long id) {
        return Optional.of(commandRepository.findById(id)).orElseThrow();
    }

    public List<CommandEntity> getCommands() {
        return commandRepository.findAll();
    }
}
