package com.tidz.leRev.service;

import com.tidz.leRev.exception.EmptyResourceError;
import com.tidz.leRev.model.Car;
import com.tidz.leRev.repository.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

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
}
