package be.businesstraining.rest;

import be.businesstraining.domain.Flat;
import be.businesstraining.domain.House;
import be.businesstraining.repository.FlatsRepository;
import be.businesstraining.repository.HousesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/houses")
@CrossOrigin
public class HousesRestController {
    private HousesRepository housesrepository;

    public HousesRestController(HousesRepository housesrepository){
        this.housesrepository = housesrepository;
    }
    @GetMapping
    public List<House> findAll() {
        return housesrepository.findAll();
    }

    @GetMapping(path= "/{id}" )
    public ResponseEntity<House> findById(@PathVariable("id") String id) {
        Optional<House> resultat =  housesrepository.findById(id);
        if (resultat.isPresent())
            return new ResponseEntity<>(resultat.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public  ResponseEntity<House> create(@RequestBody House c){

        if (!housesrepository.findById(c.getId()).isPresent())
        {
            housesrepository.save(c);
            return new ResponseEntity<House>(c, HttpStatus.CREATED);
        } else
            return new ResponseEntity<House>(HttpStatus.NOT_ACCEPTABLE);
    }
    @PutMapping
    public  ResponseEntity<House> update(@RequestBody House c){

        try {
            housesrepository.save(c);
            return new ResponseEntity<House>(c, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<House>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    @DeleteMapping(path= "/{id}" )
    public  ResponseEntity<House> deleteById(@PathVariable("id") String id) {
        Optional<House> resultat =  housesrepository.findById(id);
        if (resultat.isPresent()) {
            housesrepository.delete(resultat.get());
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
}

