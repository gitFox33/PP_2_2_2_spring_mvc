package web.service;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private List<Car> cars;

    public CarServiceImpl() {
        cars = new ArrayList<>();
        cars.add(new Car("Ford", "Mustang", "Red"));
        cars.add(new Car("Chevrolet", "Camaro", "Green"));
        cars.add(new Car("Dodge", "Challenger", "Blue"));
        cars.add(new Car("Cadillac", "Escalade", "White"));
        cars.add(new Car("Jaguar", "Skylark", "Black"));
    }

    @Override
    public List<Car> getAllCars() {
        return cars;
    }

    @Override
    public List<Car> getCars(int count) {
        if (count < 0 || count > cars.size()) {
            throw new IllegalArgumentException("Invalid count");
        }
        List<Car> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(cars.get(i));
        }

        return result;
    }
}

