package com.yuri.second_car.entity;

public class CarInfo {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public double getDisplacement() {
        return displacement;
    }

    public void setDisplacement(double displacement) {
        this.displacement = displacement;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }

    public String getType_of_clutch() {
        return type_of_clutch;
    }

    public void setType_of_clutch(String type_of_clutch) {
        this.type_of_clutch = type_of_clutch;
    }

    @Override
    public String toString() {
        return "CarInfo{" +
                "id=" + id +
                ", brand_name='" + brand_name + '\'' +
                ", model_name='" + model_name + '\'' +
                ", displacement=" + displacement +
                ", price=" + price +
                ", release_date='" + release_date + '\'' +
                ", mileage=" + mileage +
                ", registration_date='" + registration_date + '\'' +
                ", type_of_clutch='" + type_of_clutch + '\'' +
                '}' + '\n';
    }

    private int id;
    private String brand_name;
    private String model_name;
    private double displacement;
    private double price;
    private String release_date;

    private double mileage;
    private String registration_date;
    private String type_of_clutch;

}
