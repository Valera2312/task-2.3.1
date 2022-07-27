package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.models.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    CarDao carDao;

    @Autowired
    CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<Car> listCar() {
        return carDao.listCar();
    }

    @Override
    public List<Car> limitListCar(Long limit) {
        return carDao.limitListCar(limit);
    }
}
