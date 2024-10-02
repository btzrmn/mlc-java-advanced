package oop04.exercise.MilitaryElite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private List<Soldier> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public Collection<Soldier> getPrivates() {
        return Collections.unmodifiableList(this.privates);
    }

    @Override
    public void addPrivate(Soldier priv) {
        this.privates.add(priv);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("Name: %s %s Id: %d Salary: %.2f", getFirstName(), getLastName(), getId(), getSalary()))
                .append(System.lineSeparator())
                .append("Privates:")
                .append(System.lineSeparator());
        for (Soldier soldier : privates) {
            str.append("  ")
                    .append(soldier.toString())
                    .append(System.lineSeparator());
        }
        return str.toString().trim();
    }
}
