package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
public class CarsController  {

    private final CarService carService;

    @Autowired
    CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String getCars(ModelMap model, @RequestParam("limit") long limit) {


        if (limit > 4) {
            model.addAttribute("cars",carService.listCar());
        } else {
            model.addAttribute("cars",carService.limitListCar(limit));
        }
        return "cars";
    }

}
