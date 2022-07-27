package web.dao;

import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.models.Car;

import java.util.List;


public interface CarDao {
    List<Car> listCar();
    List<Car> limitListCar(Long limit);
}
