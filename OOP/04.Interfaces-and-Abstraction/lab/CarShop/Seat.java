package oop04.lab.CarShop;


public class Seat extends CarImpl implements Sellable {
    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires %s sells for %.6f",
                this.getModel(),
                this.getCountryProduced(),
                this.TIRES, this.getModel(), this.getPrice());
    }
}
