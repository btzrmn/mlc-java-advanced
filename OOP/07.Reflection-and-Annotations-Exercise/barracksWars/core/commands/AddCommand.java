package barracksWars.core.commands;

import barracksWars.interfaces.Inject;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;

public class AddCommand extends Command {

    @Inject
    private Repository repository;

    @Inject
    private UnitFactory unitFactory;

    public AddCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        Unit unitToAdd = null;
        unitToAdd = this.unitFactory.createUnit(unitType);

        this.repository.addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}
