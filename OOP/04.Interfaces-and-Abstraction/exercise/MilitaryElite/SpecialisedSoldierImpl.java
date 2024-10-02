package oop04.exercise.MilitaryElite;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private Corp corp;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary);
        this.setCorp(corp);
    }

    private void setCorp(String corp) {
        if (!corp.equals("Airforces") && !corp.equals("Marines")) {
            throw new IllegalArgumentException("Invalid corp");
        }
        this.corp = Corp.valueOf(corp);
    }

    @Override
    public Corp getCorp() {
        return corp;
    }
}
