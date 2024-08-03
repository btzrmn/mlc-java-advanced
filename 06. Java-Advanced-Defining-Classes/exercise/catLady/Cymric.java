package class06.exercise.catLady;

public class Cymric extends Cat {

    private double furLength;

    public Cymric(String type, String name, double furLength) {
        super(type, name);
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", super.toString(), this.furLength);
    }
}
