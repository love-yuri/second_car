package com.yuri.second_car.util;

import com.yuri.second_car.entity.*;
import com.yuri.second_car.mapper.carsMapper;

import java.util.List;

public class SqlQuery {
    private final carsMapper carsMapper;
    public SqlQuery(carsMapper carsMapper) {
        this.carsMapper = carsMapper;
    }

    public List<Cars> getAllCars() {
        List<Cars> cars = carsMapper.allCar();
        if(cars.size() == 0) {
            System.out.println("车辆数量为0\n");
        }
        return cars;
    }

    public List<Users> getAllUsers() {
        List<Users> users = carsMapper.allUser();
        if(users.size() == 0) {
            System.out.println("用户数量为0\n");
        }
        return users;
    }

    public List<CarBrand> getAllBrands() {
        List<CarBrand> carBrands = carsMapper.allBrand();
        if(carBrands.size() == 0) {
            System.out.println("厂家数量为0\n");
        }
        return carBrands;
    }

    public List<CarModel> getAllModels() {
        List<CarModel> carModels = carsMapper.allModel();
        if(carModels.size() == 0) {
            System.out.println("车型数量为0\n");
        }
        return carModels;
    }

    public List<Collect> getAllCollects() {
        List<Collect> collects = carsMapper.allCollect();
        if(collects.size() == 0) {
            System.out.println("收藏数量为0\n");
        }
        return collects;
    }

    public Collect getCollect(Collect collect) {
        Collect get = carsMapper.collect(collect);
        if(get == null) {
            System.out.println("没有该收藏 -> " + collect);
        }
        return get;
    }

    public List<CarInfo> getAllCarInfo() {
        List<CarInfo> carsInfos = carsMapper.allCarInfo();
        if(carsInfos.size() == 0) {
            System.out.println("汽车数量为0\n");
        }
        return carsInfos;
    }

    public CarInfo getCarInfo(int id) {
        CarInfo carInfo = carsMapper.carInfo(id);
        if(carInfo == null) {
            System.out.println(id + " 该用户不存在!");
        }
        return carInfo;
    }

    public List<CarInfo> getAllCollectInfo(int id) {
        List<CarInfo> collectInfos = carsMapper.allCollectInfo(id);
        if(collectInfos.size() == 0) {
            System.out.println(id + " 该用户没有收藏!");
        }

        return collectInfos;
    }

    public List<CarInfo> getStorehouse(int id) {
        List<CarInfo> collectInfos = carsMapper.allStorehouse(id);
        if(collectInfos.size() == 0) {
            System.out.println(id + " 该用户没有购买任何车辆!");
        }

        return collectInfos;
    }

    public int addCollect(Collect collect) {
        if(carsMapper.collect(collect) != null) {
            System.out.println("该收藏已经存在 -> " + collect);
            return -1;
        }
        return carsMapper.addCollect(collect);
    }

    public int delCollect(Collect collect) {
        if(carsMapper.collect(collect) == null) {
            System.out.println("该收藏不存在 -> " + collect);
            return -1;
        }
        return carsMapper.delCollect(collect);
    }

    public int addStorehouse(Storehouse storehouse) {
        if(carsMapper.storehouse(storehouse) != null) {
            System.out.println("该购买已经存在 -> " + storehouse);
            return -1;
        }
        return carsMapper.addStorehouse(storehouse);
    }

    public int delStorehouse(Storehouse storehouse) {
        if(carsMapper.storehouse(storehouse) == null) {
            System.out.println("该购买不存在 -> " + storehouse);
            return -1;
        }
        return carsMapper.delStorehouse(storehouse);
    }

    public CarBrand brand(CarBrand carBrand) {
        if(carBrand == null) {
            System.out.println("carBrand 为空!");
        }
        return carsMapper.brand(carBrand);
    }

    public int addBrand(CarBrand carBrand) {
        if(brand(carBrand) != null) {
            System.out.println("该用户已经存在");
            return -1;
        }
        return carsMapper.addBrand(carBrand);
    }

    public CarModel model(CarModel carModel) {
        if(carModel == null) {
            System.out.println("carModel 为空!");
        }
        return carsMapper.module(carModel);
    }

    public int addModel(CarModel carModel) {
        if(model(carModel) != null) {
            System.out.println("该车型已经存在");
            return -1;
        }
        return carsMapper.addModule(carModel);
    }

    public int addCar(CarInfo carInfo) {
        if(carInfo == null) {
            System.out.println("车辆信息为空!");
            return -1;
        }
        CarBrand carBrand = new CarBrand();
        carBrand.setName(carInfo.getBrand_name());
        carBrand = brand(carBrand);
        CarModel carModel = new CarModel();
        carModel.setName(carInfo.getModel_name());
        carModel.setBrand_id(carBrand.getId());
        carModel = model(carModel);

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

    public int delBrand(CarBrand carBrand) {
        if(brand(carBrand) == null) {
            System.out.println("该品牌不存在无法删除!");
            return -1;
        }
        return carsMapper.delBrand(carBrand.getId());
    }

    public CarModel modelById(int id) {
        CarModel carModel = carsMapper.modelById(id);
        if(carModel == null) {
            System.out.println("该车型不存在!");
        }
        return carModel;
    }

    public int delModel(CarModel carModel) {
        if(modelById(carModel.getId()) == null) {
            return -1;
        }
        return carsMapper.delModel(carModel.getId());
    }

}
