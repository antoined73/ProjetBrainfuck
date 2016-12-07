package language.instructions.instructionFactory;

import language.Instruction;
import language.instructions.Jump;

/**
 * Created by Desla on 01/12/2016.
 */
public class JumpFactory extends InstructionFactory {

    int instructionCount;

    public JumpFactory(int instructionCount) {
        this.instructionCount=instructionCount;
    }

    @Override
    public Instruction create() {
        return new Jump(instructionCount);
    }
}
