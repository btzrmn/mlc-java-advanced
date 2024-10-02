package football.entities.player;

public class Women extends BasePlayer {
    private static final double DEFAULT_KG = 50;

    public Women(String name, String nationality, int strength) {
        super(name, nationality, DEFAULT_KG, strength);
    }

    @Override
    public void stimulation() {
        this.setStrength(this.getStrength() + 115);
    }
}
