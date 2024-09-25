package barracksWars.core.commands;

import barracksWars.interfaces.Inject;
import barracksWars.interfaces.Repository;
import jdk.jshell.spi.ExecutionControl;

public class RetireCommand extends Command {

    @Inject
    private Repository repository;

    public RetireCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        String response = unitType + " retired!";
        try {
            this.repository.removeUnit(unitType);
        } catch( ExecutionControl.NotImplementedException e) {
            return e.getMessage();
        }
        return response;
    }
}
