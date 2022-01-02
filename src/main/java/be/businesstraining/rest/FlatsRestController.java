package be.businesstraining.rest;

import be.businesstraining.domain.Flat;
import be.businesstraining.repository.FlatsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flats")
@CrossOrigin
public class FlatsRestController {
    private FlatsRepository repository;

    public FlatsRestController(FlatsRepository repository){
        this.repository = repository;
    }
    @GetMapping
    public List<Flat> findAll() {
        return repository.findAll();
    }

    @GetMapping(path= "/{id}" )
    public ResponseEntity<Flat> findById(@PathVariable("id") String id) {
        Optional<Flat> resultat =  repository.findById(id);
        if (resultat.isPresent())
            return new ResponseEntity<>(resultat.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public  ResponseEntity<Flat> create(@RequestBody Flat c){

        if (!repository.findById(c.getId()).isPresent())
        {
            repository.save(c);
            return new ResponseEntity<Flat>(c, HttpStatus.CREATED);
        } else
            return new ResponseEntity<Flat>(HttpStatus.NOT_ACCEPTABLE);
    }
    @PutMapping
    public  ResponseEntity<Flat> update(@RequestBody Flat c){

        try {
            repository.save(c);
            return new ResponseEntity<Flat>(c, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<Flat>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    @DeleteMapping(path= "/{id}" )
    public  ResponseEntity<Flat> deleteById(@PathVariable("id") String id) {
        Optional<Flat> resultat =  repository.findById(id);
        if (resultat.isPresent()) {
            repository.delete(resultat.get());
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
}



