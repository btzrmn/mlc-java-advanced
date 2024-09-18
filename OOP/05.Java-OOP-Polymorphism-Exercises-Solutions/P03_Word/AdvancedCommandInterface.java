package word;

import java.util.List;

public class AdvancedCommandInterface extends CommandImpl {

    public AdvancedCommandInterface(StringBuilder text) {
        super(text);
    }

    @Override
    public List<Command> initCommands(){
        List<Command> commands = super.initCommands();

        TextTransform cutTransform = new CutTransform();
        TextTransform pasteTransform = new PasteTransform((CutTransform) cutTransform);

        commands.add(new Command("cut", cutTransform));
        commands.add(new Command("paste", pasteTransform));

        return commands;
    }
}
