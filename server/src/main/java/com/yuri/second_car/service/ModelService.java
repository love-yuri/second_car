package com.yuri.second_car.service;

import com.yuri.second_car.entity.CarModel;
import com.yuri.second_car.mapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {
    private final ModelMapper modelMapper;

    public ModelService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CarModel modelById(int id) {
        CarModel carModel = modelMapper.modelById(id);
        if(carModel == null) {
            System.out.println("该车型不存在!");
        }
        return carModel;
    }

    public int delModel(CarModel carModel) {
        if(modelById(carModel.getId()) == null) {
            return -1;
        }
        return modelMapper.delModel(carModel.getId());
    }

    public CarModel model(CarModel carModel) {
        if(carModel == null) {
            System.out.println("carModel 为空!");
        }
        return modelMapper.model(carModel);
    }

    public int addModel(CarModel carModel) {
        if(model(carModel) != null) {
            System.out.println("该车型已经存在");
            return -1;
        }
        return modelMapper.addModule(carModel);
    }

    public List<CarModel> getAllModels() {
        List<CarModel> carModels = modelMapper.allModel();
        if(carModels.isEmpty()) {
            System.out.println("车型数量为0\n");
        }
        return carModels;
    }
}
