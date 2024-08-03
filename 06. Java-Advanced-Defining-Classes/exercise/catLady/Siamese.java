package class06.exercise.catLady;

public class Siamese extends Cat {

    private double earSize;

    public Siamese(String type, String name, double earSize) {
        super(type, name);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", super.toString(), this.earSize);
    }
}
