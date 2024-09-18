package vehicles;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    public VehicleImpl(double fuelQuantity, double fuelConsumption){
        this.fuelQuantity = fuelQuantity;
        this.setFuelConsumption(fuelConsumption);
    }
    protected void setFuelConsumption(double fuelConsumption){
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String drive(double distance){
        double fuelNeeded = distance * this.fuelConsumption;

        DecimalFormat df = new DecimalFormat("#.##");

        String result = "needs refueling";

        if(this.fuelQuantity >= fuelNeeded){
            result = String.format("travelled %s km", df.format(distance));
            this.fuelQuantity -= fuelNeeded;
        }

        return result;
    }

    @Override
    public void refuel(double liters){
        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
