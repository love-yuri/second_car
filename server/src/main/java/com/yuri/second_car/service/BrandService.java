package com.yuri.second_car.service;

import com.yuri.second_car.entity.CarBrand;
import com.yuri.second_car.mapper.BrandMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BrandService {
    private final BrandMapper brandMapper;

    public BrandService(BrandMapper brandMapper) {
        this.brandMapper = brandMapper;
    }

    public CarBrand brand(CarBrand carBrand) {
        if(carBrand == null) {
            System.out.println("carBrand 为空!");
        }
        return brandMapper.brand(carBrand);
    }

    public int addBrand(CarBrand carBrand) {
        if(brand(carBrand) != null) {
            System.out.println("该用户已经存在");
            return -1;
        }
        return brandMapper.addBrand(carBrand);
    }

    public int delBrand(CarBrand carBrand) {
        if(brand(carBrand) == null) {
            System.out.println("该品牌不存在无法删除!");
            return -1;
        }
        return brandMapper.delBrand(carBrand.getId());
    }

    public List<CarBrand> getAllBrands() {
        List<CarBrand> carBrands = brandMapper.allBrand();
        if(carBrands.isEmpty()) {
            System.out.println("厂家数量为0\n");
        }
        return carBrands;
    }
}
