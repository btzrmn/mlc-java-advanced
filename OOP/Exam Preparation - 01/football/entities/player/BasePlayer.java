package football.entities.player;

public class BasePlayer implements Player {
    private String name;
    private String nationality;
    private double kg;
    private int strength;

    public BasePlayer(String name, String nationality, double kg, int strength) {
        this.setName(name);
        this.setNationality(nationality);
        this.setKg(kg);
        this.setStrength(strength);
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Player name cannot be null or empty.");
        }
        this.name = name;
    }

    @Override
    public void stimulation() {
    }

    @Override
    public double getKg() {
        return this.kg;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        if (strength <= 0) {
            throw new IllegalArgumentException("Players strength cannot be below or equal to 0.");
        }
        this.strength = strength;
    }

    public void setNationality(String nationality) {
        if (nationality == null || nationality.trim().isEmpty()) {
            throw new NullPointerException("Player nationality cannot be null or empty.");
        }
        this.nationality = nationality;
    }

    public void setKg(double kg) {
        this.kg = kg;
    }
}
