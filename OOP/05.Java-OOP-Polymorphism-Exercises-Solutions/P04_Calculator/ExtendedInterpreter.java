package calculator;

public class ExtendedInterpreter extends InputInterpreter {
    private MemoryStorage memory;

    public ExtendedInterpreter(CalculationEngine engine) {
        super(engine);
    }

    @Override
    public Operation getOperation(String operation) {
        if (operation.equals("/")) {
            return new DivisionOperation();
        } else if (operation.equals("ms")) {
            if (this.memory == null) {
                memory = new MemoryStorage();
            }

            return this.memory;
        } else if (operation.equals("mr")) {
            return new MemoryRecallOperation(this.memory);
        } else {
            return super.getOperation(operation);
        }
    }
}
