package oop04.exercise.MilitaryElite;

import java.util.Collection;

public interface Engineer extends SpecialisedSoldier {
    void addRepair(RepairImpl repair);

    Collection<Repair> getRepairs();

}
