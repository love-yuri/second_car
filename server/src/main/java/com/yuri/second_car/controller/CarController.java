package com.yuri.second_car.controller;

import com.yuri.second_car.entity.*;
import com.yuri.second_car.mapper.carsMapper;
import com.yuri.second_car.util.SqlQuery;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CarController {

    private final carsMapper carsMapper;
    SqlQuery sqlQuery;

    public CarController(carsMapper carsMapper) {
        this.carsMapper = carsMapper;
        sqlQuery = new SqlQuery(carsMapper);
    }

    @PostMapping("/hello")
    public String hello() {
        return "hello controller!";
    }

    @PostMapping("/getAllCar")
    public List<Cars> getAllCars() {
        return sqlQuery.getAllCars();
    }

    @PostMapping("/getAllBrand")
    public List<CarBrand> getAllBrands() {
        return sqlQuery.getAllBrands();
    }

    @PostMapping("/getAllModel")
    public List<CarModel> getAllModels() {
        return sqlQuery.getAllModels();
    }

    @PostMapping("/getAllCollect")
    public List<Collect> getAllCollects() {
        return sqlQuery.getAllCollects();
    }

    @PostMapping("/getAllCarInfo")
    public List<CarInfo> getAllCarsInfos() {
        return sqlQuery.getAllCarInfo();
    }

    @GetMapping("/getCarInfo")
    public CarInfo getCarInfo(int id) {
        return sqlQuery.getCarInfo(id);
    }

    @GetMapping("/getAllCollectInfo")
    public List<CarInfo> getAllCollectInfo(int id) {
        return sqlQuery.getAllCollectInfo(id);
    }

    @GetMapping("/getStorehouse")
    public List<CarInfo> getStorehouse(int id) {
        return sqlQuery.getStorehouse(id);
    }

    @PostMapping("/addCollect")
    public int addCollect(@RequestBody Collect collect) {
        return sqlQuery.addCollect(collect);
    }

    @PostMapping("/delCollect")
    public int delCollect(@RequestBody Collect collect) {
        return sqlQuery.delCollect(collect);
    }

    @PostMapping("/addStorehouse")
    public int addStorehouse(@RequestBody Storehouse storehouse) {
        return sqlQuery.addStorehouse(storehouse);
    }

    @PostMapping("/delStorehouse")
    public int delStorehouse(@RequestBody Storehouse storehouse) {
        return sqlQuery.delStorehouse(storehouse);
    }

    @PostMapping("/addBrand")
    public int addBrand(@RequestBody CarBrand carBrand) {
        return sqlQuery.addBrand(carBrand);
    }

    @PostMapping("/addModel")
    public int addModel(@RequestBody CarModel carModel) {
        return sqlQuery.addModel(carModel);
    }

    @PostMapping("/addCars")
    public int addCars(@RequestBody CarInfo carInfo) {
        return sqlQuery.addCar(carInfo);
    }

    @PostMapping("/delBrand")
    public int delBrand(@RequestBody CarBrand carBrand) {
        return sqlQuery.delBrand(carBrand);
    }

    @PostMapping("/delModel")
    public int delModel(@RequestBody CarModel carModel) {
        return sqlQuery.delModel(carModel);
    }

}
