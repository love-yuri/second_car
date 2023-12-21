package com.yuri.second_car.controller;

import com.yuri.second_car.entity.CarBrand;
import com.yuri.second_car.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class BrandController {
    @Autowired
    private BrandService brandService;

    @PostMapping("/getAllBrand")
    public List<CarBrand> getAllBrands() {
        return brandService.getAllBrands();
    }

    @PostMapping("/addBrand")
    public int addBrand(@RequestBody CarBrand carBrand) {
        return brandService.addBrand(carBrand);
    }

    @PostMapping("/delBrand")
    public int delBrand(@RequestBody CarBrand carBrand) {
        return brandService.delBrand(carBrand);
    }
}
