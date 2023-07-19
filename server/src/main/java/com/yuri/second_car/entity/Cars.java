package com.yuri.second_car.entity;

public class Cars {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDisplacement() {
        return displacement;
    }

    public void setDisplacement(double displacement) {
        this.displacement = displacement;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getType_of_clutch() {
        return type_of_clutch;
    }

    public void setType_of_clutch(String type_of_clutch) {
        this.type_of_clutch = type_of_clutch;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", displacement=" + displacement +
                ", registration_date='" + registration_date + '\'' +
                ", price=" + price +
                ", mileage=" + mileage +
                ", type_of_clutch='" + type_of_clutch + '\'' +
                ", release_date='" + release_date + '\'' +
                ", model_id=" + model_id +
                '}' + '\n';
    }

    private int id;
    private double displacement;
    private String registration_date;
    private double price;
    private double mileage;
    private String type_of_clutch;
    private String release_date;
    private int model_id;
}
