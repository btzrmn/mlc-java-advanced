package class06.exercise.carSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public Car(String model, Engine engine, int weight) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this.model = model;
        this.engine = engine;
        this.color = color;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append(this.model).append(":").append(System.lineSeparator())
                .append(this.engine)
                .append(String.format("Weight: %s", this.weight != 0 ? this.weight : "n/a")).append(System.lineSeparator())
                .append(String.format("Color: %s", this.color != null ? this.color : "n/a"));

        return str.toString();
    }
}
