package language.instructions.instructionFactory;

import language.Instruction;
import language.instructions.Back;

/**
 * Created by Desla on 01/12/2016.
 */

public class BackFactory extends InstructionFactory{

    int instructionCount;

    public BackFactory(int instructionCount) {
        this.instructionCount=instructionCount;
    }

    @Override
    public Instruction create() {
        return new Back(instructionCount);
    }
}
