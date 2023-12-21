package com.yuri.second_car.service;

import com.yuri.second_car.entity.CarInfo;
import com.yuri.second_car.entity.Storehouse;
import com.yuri.second_car.mapper.StoreHouseMapper;
import com.yuri.second_car.mapper.ViewMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreHouseService {
    private final StoreHouseMapper storeHouseMapper;
    private final ViewMapper viewMapper;

    public StoreHouseService(StoreHouseMapper storeHouseMapper, ViewMapper viewMapper) {
        this.storeHouseMapper = storeHouseMapper;
        this.viewMapper = viewMapper;
    }

    public int addStorehouse(Storehouse storehouse) {
        if(storeHouseMapper.storehouse(storehouse) != null) {
            System.out.println("该购买已经存在 -> " + storehouse);
            return -1;
        }
        return storeHouseMapper.addStorehouse(storehouse);
    }

    public int delStorehouse(Storehouse storehouse) {
        if(storeHouseMapper.storehouse(storehouse) == null) {
            System.out.println("该购买不存在 -> " + storehouse);
            return -1;
        }
        return storeHouseMapper.delStorehouse(storehouse);
    }

    public List<CarInfo> getStorehouse(int id) {
        List<CarInfo> collectInfos = viewMapper.allStorehouse(id);
        if(collectInfos.isEmpty()) {
            System.out.println(id + " 该用户没有购买任何车辆!");
        }
        return collectInfos;
    }
}
