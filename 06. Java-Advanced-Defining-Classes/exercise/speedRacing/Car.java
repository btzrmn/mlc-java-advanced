package class06.exercise.speedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPerKilometer;
    private int travelledDistance;

    public Car(String model, double fuelAmount, double fuelCostPerKilometer) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKilometer = fuelCostPerKilometer;
        this.travelledDistance = 0;
    }

    private double calcFuelByAmountOfKilometers(int kilometer) {
        return this.fuelCostPerKilometer * kilometer;
    }

    public boolean hasSufficient(int kilometer) {
        return this.fuelAmount >= this.calcFuelByAmountOfKilometers(kilometer);
    }

    public void reduceFuel(int kilometer) {
        this.fuelAmount -= this.calcFuelByAmountOfKilometers(kilometer);
    }

    public void increaseDistance(int kilometer) {
        this.travelledDistance += kilometer;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.travelledDistance);
    }
}
