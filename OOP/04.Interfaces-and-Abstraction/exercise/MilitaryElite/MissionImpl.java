package oop04.exercise.MilitaryElite;

public class MissionImpl implements Mission {
    private String codeName;
    private State state;

    public MissionImpl(String codeName, String state) {
        this.codeName = codeName;
        this.setState(state);
    }

    public void setState(String state) {

        if (!state.equals("inProgress") && !state.equals("finished")) {
            throw new IllegalArgumentException("invalid mission state");
        }
        this.state = State.valueOf(state);
    }

    @Override
    public String getCodeName() {
        return codeName;
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", codeName, state.toString());
    }
}
