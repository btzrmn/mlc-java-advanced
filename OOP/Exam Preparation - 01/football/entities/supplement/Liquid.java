package football.entities.supplement;

public class Liquid extends BaseSupplement {
    private static final int DEFAULT_ENERGY = 90;
    private static final double DEFAULT_PRICE = 25;

    public Liquid() {
        super(DEFAULT_ENERGY, DEFAULT_PRICE);
    }
}
