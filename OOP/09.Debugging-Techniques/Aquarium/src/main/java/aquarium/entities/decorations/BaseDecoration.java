package aquarium.entities.decorations;

public abstract class BaseDecoration implements Decoration {
    private int comfort;
    private double price;

    public BaseDecoration(int comfort, double price) {
        this.comfort = comfort;
        this.price = price;
    }

    public int getComfort() {
        return this.comfort;
    }

    public double getPrice() {
        return this.price;
    }

}
