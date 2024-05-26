package malika.application.logstashsenderapplication.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import malika.application.logstashsenderapplication.model.Person;
import malika.application.logstashsenderapplication.repository.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/person")
public class PersonController {
    private final PersonRepository personRepository;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        log.info(person.toString());
        return ResponseEntity.ok(personRepository.save(person));
    }
    @GetMapping
    public ResponseEntity<List<Person>> getAll(){
        log.info("People are going to logged");
        return ResponseEntity.ok(personRepository.findAll());
    }
}
