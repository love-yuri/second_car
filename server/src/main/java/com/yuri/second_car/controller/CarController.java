package com.yuri.second_car.controller;

import com.yuri.second_car.entity.*;
import com.yuri.second_car.mapper.CarsMapper;
import com.yuri.second_car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CarController {

    @Autowired
    private CarService carService;
    @PostMapping("/getAllCar")
    public List<Cars> getAllCars() {
        return carService.getAllCars();
    }


    @PostMapping("/getAllCarInfo")
    public List<CarInfo> getAllCarsInfos() {
        return carService.getAllCarInfo();
    }

    @GetMapping("/getCarInfo")
    public CarInfo getCarInfo(int id) {
        return carService.getCarInfo(id);
    }



    @PostMapping("/addCars")
    public int addCars(@RequestBody CarInfo carInfo) {
        return carService.addCar(carInfo);
    }



}
