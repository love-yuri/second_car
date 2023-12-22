package com.yuri.second_car.controller;

import com.yuri.second_car.entity.CarInfo;
import com.yuri.second_car.entity.History;
import com.yuri.second_car.entity.Users;
import com.yuri.second_car.query.SearchQuery;
import com.yuri.second_car.result.R;
import com.yuri.second_car.service.CarService;
import com.yuri.second_car.service.OssService;
import com.yuri.second_car.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("oss")
public class OssController {
    @Autowired
    private OssService ossService;

    @Autowired
    private UserService userService;

    @GetMapping("spark/{msg}")
    public R<String> spark(@PathVariable String msg) {
        return ossService.spark(msg);
    }

    @PostMapping("search")
    public R<List<CarInfo>> search(@RequestBody SearchQuery msg) {
        return ossService.search(msg);
    }

    @PostMapping("hot")
    public R<List<CarInfo>> hot(@RequestBody SearchQuery msg) {
        return ossService.hot(msg);
    }

    @PostMapping("history")
    public R<List<History>> historyList(@RequestBody SearchQuery msg) {
        return ossService.historyList(msg);
    }

    @PostMapping("delHistory")
    public R<Boolean> delHistory(@RequestBody History history) {
        return ossService.delHistory(history);
    }
}
