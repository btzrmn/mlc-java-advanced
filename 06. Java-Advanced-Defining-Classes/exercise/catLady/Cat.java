package class06.exercise.catLady;

public class Cat {
    private String type;
    private String name;

    public Cat(String type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.type, this.name);
    }
}
