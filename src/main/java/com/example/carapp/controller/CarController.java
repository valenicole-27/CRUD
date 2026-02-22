package com.example.carapp.controller;

import com.example.carapp.model.Car;
import com.example.carapp.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // CREATE
    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    // READ ALL
    @GetMapping
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id) {
        if (!carRepository.existsById(id)) {
            return new Car();
        }
        return carRepository.findById(id).get();
    }

    // UPDATE TYPE
    @PutMapping("/{id}")
    public Car updateCarType(@PathVariable Long id,
                             @RequestParam String type) {

        if (!carRepository.existsById(id)) {
            return new Car();
        }

        Car car = carRepository.findById(id).get();
        car.setType(type);
        return carRepository.save(car);
    }

    // DELETE ONE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {

        if (!carRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        carRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // DELETE ALL
    @DeleteMapping
    public void deleteAllCars() {
        carRepository.deleteAll();
    }
}
