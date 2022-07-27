package web.service;

import web.models.Car;

import java.util.List;

public interface CarService {
    List<Car> listCar();
    List<Car> limitListCar(Long limit);
}
