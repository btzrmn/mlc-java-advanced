package class06.exercise.carSalesman;

public class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
    }

    public Engine(String model, int power, int displacement) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
    }

    public Engine(String model, int power, String efficiency) {
        this.model = model;
        this.power = power;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append(this.model).append(":").append(System.lineSeparator())
                .append(String.format("Power: %d", this.power)).append(System.lineSeparator())
                .append(String.format("Displacement: %s", this.displacement != 0 ? this.displacement : "n/a")).append(System.lineSeparator())
                .append(String.format("Efficiency: %s", this.efficiency != null ? this.efficiency : "n/a")).append(System.lineSeparator());

        return str.toString();
    }
}
