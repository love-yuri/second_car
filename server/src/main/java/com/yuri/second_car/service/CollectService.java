package com.yuri.second_car.service;

import com.yuri.second_car.entity.CarInfo;
import com.yuri.second_car.entity.Collect;
import com.yuri.second_car.mapper.CollectMapper;
import com.yuri.second_car.mapper.ViewMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectService {

    private final CollectMapper collectMapper;
    private final ViewMapper viewMapper;

    public CollectService(CollectMapper collectMapper, ViewMapper viewMapper) {
        this.collectMapper = collectMapper;
        this.viewMapper = viewMapper;
    }

    public int addCollect(Collect collect) {
        if(collectMapper.collect(collect) != null) {
            System.out.println("该收藏已经存在 -> " + collect);
            return -1;
        }
        return collectMapper.addCollect(collect);
    }

    public int delCollect(Collect collect) {
        if(collectMapper.collect(collect) == null) {
            System.out.println("该收藏不存在 -> " + collect);
            return -1;
        }
        return collectMapper.delCollect(collect);
    }

    public List<CarInfo> getAllCollectInfo(int id) {
        List<CarInfo> collectInfos = viewMapper.allCollectInfo(id);
        if(collectInfos.isEmpty()) {
            System.out.println(id + " 该用户没有收藏!");
        }

        return collectInfos;
    }

    public List<Collect> getAllCollects() {
        List<Collect> collects = collectMapper.allCollect();
        if(collects.isEmpty()) {
            System.out.println("收藏数量为0\n");
        }
        return collects;
    }

    public Collect getCollect(Collect collect) {
        Collect get = collectMapper.collect(collect);
        if(get == null) {
            System.out.println("没有该收藏 -> " + collect);
        }
        return get;
    }

}
