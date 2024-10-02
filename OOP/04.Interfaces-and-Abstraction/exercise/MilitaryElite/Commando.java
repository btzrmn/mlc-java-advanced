package oop04.exercise.MilitaryElite;

import java.util.Collection;

public interface Commando extends SpecialisedSoldier {
    void addMission(MissionImpl mission);

    Collection<Mission> getMissions();

}
