package word;

public class Initialization {
    public static CommandInterface buildCommandInterface(StringBuilder text){
        CommandInterface commandInterface = new AdvancedCommandInterface(text);
        commandInterface.init();
        return commandInterface;
    }
}
