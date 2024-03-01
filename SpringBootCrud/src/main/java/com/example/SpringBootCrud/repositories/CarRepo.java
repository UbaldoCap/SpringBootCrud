package com.example.SpringBootCrud.repositories;

import com.example.SpringBootCrud.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {
}
