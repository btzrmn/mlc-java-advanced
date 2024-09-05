package class11.lab.HotelReservation;

public enum Discount {
    NONE(0),
    SECOND_VISIT(10),
    VIP(20);
    private int value;

    Discount(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Discount getDiscount(String discount) {
        switch (discount) {
            case "VIP":
                return VIP;
            case "SecondVisit":
                return SECOND_VISIT;
            case "None":
                return NONE;
            default:
                throw new IllegalArgumentException("Unknown discount " + discount);
        }
    }
}
