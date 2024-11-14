package com.tidz.leRev.service;

import com.tidz.leRev.exception.EmptyResourceError;
import com.tidz.leRev.exception.InternalServerError;
import com.tidz.leRev.model.Car;
import com.tidz.leRev.model.CarModel;
import com.tidz.leRev.repository.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.Year;

@SpringBootTest
public class CarServiceTest {

    @Mock
    private CarRepository repository;

    @InjectMocks
    private CarService service;

    @BeforeEach
    void setup() {
        MockMvcBuilders.standaloneSetup(this);
    }

    @Test
    void shouldReturnAnErrorIfNoCarIsProvided() {
        Car car = null;

        Assertions.assertThrows(EmptyResourceError.class, () -> {
            service.add(car);
        });

    }

    @Test
    void serviceShouldThrowAnErrorIfRepositoryFails() {
        Car car = new Car();

        Mockito.when(repository.save(car)).thenThrow(InternalServerError.class);

        Assertions.assertThrows(InternalServerError.class, () -> {
            service.add(car);
        });
    }

    @Test
    void serviceShouldReturnACarWhenSuccess() {
        Car car = new Car("Audi RS4", CarModel.SEDAN, Year.of(1996), "blue");

        Mockito.when(repository.save(car)).thenReturn(car);
        Car returnedCar = service.add(car);

        Assertions.assertEquals(car.getName(), returnedCar.getName());
        Assertions.assertEquals(car.getModel(), returnedCar.getModel());
        Assertions.assertEquals(car.getYear(), returnedCar.getYear());
        Assertions.assertEquals(car.getColor(), returnedCar.getColor());
    }
}
