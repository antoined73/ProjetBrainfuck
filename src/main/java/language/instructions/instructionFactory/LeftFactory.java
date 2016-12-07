package language.instructions.instructionFactory;

import language.Instruction;
import language.instructions.Left;

/**
 * Created by Desla on 01/12/2016.
 */
public class LeftFactory extends InstructionFactory {

    @Override
    public Instruction create() {
        return new Left();
    }
}
