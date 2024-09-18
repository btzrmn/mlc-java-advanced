package vehiclesExtension;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public VehicleImpl(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    private void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    @Override
    public String drive(double distance) {
        double fuelNeeded = distance * this.fuelConsumption;

        DecimalFormat df = new DecimalFormat("#.##");
        String result = "needs refueling";

        if (this.fuelQuantity >= fuelNeeded) {
            result = String.format("travelled %s km", df.format(distance));
            this.fuelQuantity -= fuelNeeded;
        }

        return result;
    }

    @Override
    public void refuel(double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        double newFuelQuantity = this.fuelQuantity + liters;

        if (newFuelQuantity > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
