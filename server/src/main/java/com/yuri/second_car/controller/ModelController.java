package com.yuri.second_car.controller;


import com.yuri.second_car.entity.CarModel;
import com.yuri.second_car.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ModelController {

    @Autowired
    private ModelService modelService;

    @PostMapping("/getAllModel")
    public List<CarModel> getAllModels() {
        return modelService.getAllModels();
    }

    @PostMapping("/addModel")
    public int addModel(@RequestBody CarModel carModel) {
        return modelService.addModel(carModel);
    }

    @PostMapping("/delModel")
    public int delModel(@RequestBody CarModel carModel) {
        return modelService.delModel(carModel);
    }
}
