package football.entities.player;

public class Men extends BasePlayer {
    private static final double DEFAULT_KG = 85.5;

    public Men(String name, String nationality, int strength) {
        super(name, nationality, DEFAULT_KG, strength);
    }

    @Override
    public void stimulation() {
        this.setStrength(this.getStrength() + 145);
    }
}
