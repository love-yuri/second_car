package com.yuri.second_car.entity;

public class Collect {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", car_id=" + car_id +
                '}' + '\n';
    }

    private int id;
    private int user_id;
    private int car_id;
}
