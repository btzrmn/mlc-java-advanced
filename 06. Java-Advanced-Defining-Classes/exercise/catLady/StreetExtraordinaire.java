package class06.exercise.catLady;


public class StreetExtraordinaire extends Cat {

    private double decibelsOfMeows;

    public StreetExtraordinaire(String type, String name, double decibelsOfMeows) {
        super(type, name);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", super.toString(), this.decibelsOfMeows);
    }
}