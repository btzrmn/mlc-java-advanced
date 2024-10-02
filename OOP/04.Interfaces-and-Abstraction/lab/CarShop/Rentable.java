package oop04.lab.CarShop;

public interface Rentable extends Car {
    Integer getMinRentDay();

    Double getPricePerDay();
}
