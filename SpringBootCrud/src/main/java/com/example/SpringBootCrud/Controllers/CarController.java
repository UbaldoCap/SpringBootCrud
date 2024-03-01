package com.example.SpringBootCrud.Controllers;

import com.example.SpringBootCrud.entities.Car;
import com.example.SpringBootCrud.repositories.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarRepo carRepo;

    @PostMapping("/create")
    public Car create(@RequestBody Car car) {
        return carRepo.save(car);
    }

    @GetMapping("/getall")
    public List<Car> getall() {
        return carRepo.findAll();
    }

    @GetMapping("/getcar/{id}")
    public Car getcar(@PathVariable long id) {
        if (carRepo.existsById(id)) {
            return carRepo.getReferenceById(id);
        } else {
            return new Car();
        }
    }

    @PutMapping("/updatetype/{id}")
    public Car updatecar(@PathVariable long id, @RequestParam String type) {
        if (carRepo.existsById(id)) {
            Car car = carRepo.getReferenceById(id);
            car.setType(type);
            carRepo.save(car);
            return car;
        } else {
            return new Car();
        }
    }

    @DeleteMapping("/deletecar/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        if (carRepo.existsById(id)) {
            carRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/deleteall")
    public void deleteall() {
        carRepo.deleteAll();
    }
}
