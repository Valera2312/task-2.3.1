package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import web.service.CarService;

@Controller
public class CarsController  {

    CarService carService;
    @Autowired
    CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars/{limit}")
    public String printWelcome(ModelMap model, @PathVariable long limit) {


        if(limit > 4) {
            model.addAttribute("cars",carService.listCar());
        } else {
            model.addAttribute("cars",carService.limitListCar(limit));
        }
        return "cars";
    }

}
