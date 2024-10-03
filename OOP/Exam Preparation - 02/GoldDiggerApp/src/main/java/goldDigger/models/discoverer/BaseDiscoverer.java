package goldDigger.models.discoverer;

import goldDigger.common.ExceptionMessages;
import goldDigger.models.museum.BaseMuseum;
import goldDigger.models.museum.Museum;

public abstract class BaseDiscoverer implements Discoverer {
    private String name;
    private double energy;
    private Museum museum;

    public BaseDiscoverer(String name, double energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.museum = new BaseMuseum();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.DISCOVERER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    public String getName() {
        return this.name;
    }

    public double getEnergy() {
        return this.energy;
    }

    public boolean canDig() {
        return this.energy > 0;
    }

    public Museum getMuseum() {
        return this.museum;
    }

    public void dig() {
        double tempEnergy = this.energy - 15;
        if (tempEnergy < 0) {
            this.energy = 0;
        } else {
            this.energy = tempEnergy;
        }
    }
}
