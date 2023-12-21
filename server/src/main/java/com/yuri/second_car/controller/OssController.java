package com.yuri.second_car.controller;

import com.yuri.second_car.result.R;
import com.yuri.second_car.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("oss")
public class OssController {
    @Autowired
    private OssService ossService;

    @GetMapping("spark/{msg}")
    public R<String> spark(@PathVariable String msg) {
        return ossService.spark(msg);
    }

    @GetMapping("test/{msg}")
    public R<String> test(@PathVariable String msg) {
        return ossService.test(msg);
    }
}
