package com.tidz.leRev.repository;

import com.tidz.leRev.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
