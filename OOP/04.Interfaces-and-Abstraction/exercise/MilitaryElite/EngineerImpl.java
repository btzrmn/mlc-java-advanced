package oop04.exercise.MilitaryElite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private List<RepairImpl> repairList;

    public EngineerImpl(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary, corp);
        this.repairList = new ArrayList<>();
    }

    @Override
    public void addRepair(RepairImpl repair) {
        this.repairList.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return Collections.unmodifiableList(this.repairList);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("Name: %s %s Id: %d Salary: %.2f", getFirstName(), getLastName(), getId(), getSalary()));
        str.append(System.lineSeparator())
                .append("Corps: ").append(getCorp()).append(System.lineSeparator())
                .append("Repairs:").append(System.console());
        for (RepairImpl repair : repairList) {
            str.append("  ")
                    .append(repair.toString())
                    .append(System.lineSeparator());
        }
        return str.toString().trim();
    }
}
