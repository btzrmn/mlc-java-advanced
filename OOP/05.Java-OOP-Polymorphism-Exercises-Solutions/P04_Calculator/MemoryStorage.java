package calculator;

import java.util.ArrayDeque;

public class MemoryStorage implements Operation {
    private ArrayDeque<Integer> memory;

    public MemoryStorage(){
        this.memory = new ArrayDeque<>();
    }

    @Override
public void addOperand(int operand){
        this.memory.push(operand);
    }

    @Override
    public boolean isCompleted(){
        return false;
    }

    @Override
    public int getResult(){
        return this.memory.pop();
    }
}