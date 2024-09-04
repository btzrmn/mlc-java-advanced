package class11.lab.HotelReservation;

public enum Season {
    SUMMER(4),
    WINTER(3),
    SPRING(2),
    AUTUMN(1);

    private int size;
    Season(int size){
        this.size = size;
    }

    public int getValue() {
        return this.size;
    }
}
