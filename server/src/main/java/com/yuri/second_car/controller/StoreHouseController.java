package com.yuri.second_car.controller;

import com.yuri.second_car.entity.CarInfo;
import com.yuri.second_car.entity.Storehouse;
import com.yuri.second_car.service.StoreHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class StoreHouseController {

    @Autowired
    private StoreHouseService service;

    @PostMapping("/addStorehouse")
    public int addStorehouse(@RequestBody Storehouse storehouse) {
        return service.addStorehouse(storehouse);
    }

    @PostMapping("/delStorehouse")
    public int delStorehouse(@RequestBody Storehouse storehouse) {
        return service.delStorehouse(storehouse);
    }

    @GetMapping("/getStorehouse")
    public List<CarInfo> getStorehouse(int id) {
        return service.getStorehouse(id);
    }
}
