package com.yuri.second_car.controller;

import com.yuri.second_car.entity.CarInfo;
import com.yuri.second_car.entity.Collect;
import com.yuri.second_car.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CollectController {


    @Autowired
    private CollectService collectService;
    @PostMapping("/addCollect")
    public int addCollect(@RequestBody Collect collect) {
        return collectService.addCollect(collect);
    }

    @PostMapping("/delCollect")
    public int delCollect(@RequestBody Collect collect) {
        return collectService.delCollect(collect);
    }

    @GetMapping("/getAllCollectInfo")
    public List<CarInfo> getAllCollectInfo(int id) {
        return collectService.getAllCollectInfo(id);
    }

    @PostMapping("/getAllCollect")
    public List<Collect> getAllCollects() {
        return collectService.getAllCollects();
    }
}
