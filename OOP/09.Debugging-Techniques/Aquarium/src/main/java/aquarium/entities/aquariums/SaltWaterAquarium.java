package aquarium.entities.aquariums;

public class SaltWaterAquarium extends BaseAquarium {
    private static int CAPACITY = 25;

    public SaltWaterAquarium(String name) {
        super(name, CAPACITY);
    }
}
