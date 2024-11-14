package com.tidz.leRev.service;

import com.tidz.leRev.exception.EmptyResourceError;
import com.tidz.leRev.model.Car;
import com.tidz.leRev.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car add(Car newCar) {
        if (newCar == null) {
            throw new EmptyResourceError("A car must be provided");
        }

        carRepository.save(newCar);
        return null;
    }
}
