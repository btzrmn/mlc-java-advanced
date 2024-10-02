package oop04.exercise.MilitaryElite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {

    private List<MissionImpl> missionList;

    public CommandoImpl(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary, corp);
        this.missionList = new ArrayList<>();
    }

    @Override
    public void addMission(MissionImpl mission) {
        this.missionList.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return Collections.unmodifiableList(this.missionList);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("Name: %s %s Id: %d Salary: %.2f", getFirstName(), getLastName(), getId(), getSalary()));
        str.append(System.lineSeparator())
                .append("Corps: ").append(getCorp()).append(System.lineSeparator())
                .append("Missions:").append(System.lineSeparator());
        for (MissionImpl mission : missionList) {
            str.append("  ")
                    .append(mission.toString())
                    .append(System.lineSeparator());
        }
        return str.toString().trim();
    }
}
