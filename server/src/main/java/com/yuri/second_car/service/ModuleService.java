package com.yuri.second_car.service;

import com.yuri.second_car.entity.CarModel;
import com.yuri.second_car.mapper.ModuleMapper;
import org.springframework.stereotype.Service;

@Service
public class ModuleService {
    private final ModuleMapper moduleMapper;

    public ModuleService(ModuleMapper moduleMapper) {
        this.moduleMapper = moduleMapper;
    }


}
