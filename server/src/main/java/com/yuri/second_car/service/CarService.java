package com.yuri.second_car.service;

import com.yuri.second_car.entity.CarBrand;
import com.yuri.second_car.entity.CarInfo;
import com.yuri.second_car.entity.CarModel;
import com.yuri.second_car.entity.Cars;
import com.yuri.second_car.mapper.CarsMapper;
import com.yuri.second_car.mapper.ViewMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarsMapper carsMapper;
    private final BrandService brandService;
    private final ModelService modelService;
    private final ViewMapper viewMapper;


    public CarService(CarsMapper carsMapper, BrandService brandService, ModelService moduleService, ViewMapper viewMapper) {
        this.carsMapper = carsMapper;
        this.brandService = brandService;
        this.modelService = moduleService;
        this.viewMapper = viewMapper;
    }

    public List<Cars> getAllCars() {
        List<Cars> cars = carsMapper.allCar();
        if(cars.isEmpty()) {
            System.out.println("车辆数量为0\n");
        }
        return cars;
    }

    public int addCar(CarInfo carInfo) {
        if(carInfo == null) {
            System.out.println("车辆信息为空!");
            return -1;
        }
        CarBrand carBrand = new CarBrand();
        carBrand.setName(carInfo.getBrand_name());
        carBrand = brandService.brand(carBrand);
        CarModel carModel = new CarModel();
        carModel.setName(carInfo.getModel_name());
        carModel.setBrand_id(carBrand.getId());
        carModel = modelService.model(carModel);

        Cars cars = new Cars();
        cars.setDisplacement(carInfo.getDisplacement());
        cars.setMileage(carInfo.getMileage());
        cars.setPrice(carInfo.getPrice());
        cars.setModel_id(carModel.getId());
        cars.setRegistration_date(carInfo.getRegistration_date());
        cars.setType_of_clutch(carInfo.getType_of_clutch());
        cars.setRelease_date(carInfo.getRelease_date());

        return carsMapper.addCars(cars);
    }

    public List<CarInfo> getAllCarInfo() {
        List<CarInfo> carsInfos = viewMapper.allCarInfo();
        if(carsInfos.isEmpty()) {
            System.out.println("汽车数量为0\n");
        }
        return carsInfos;
    }

    public CarInfo getCarInfo(int id) {
        CarInfo carInfo = viewMapper.carInfo(id);
        if(carInfo == null) {
            System.out.println(id + " 该用户不存在!");
        }
        return carInfo;
    }
}
