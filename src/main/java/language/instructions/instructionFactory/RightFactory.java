package language.instructions.instructionFactory;

import language.Instruction;
import language.instructions.Right;

/**
 * Created by Desla on 01/12/2016.
 */
public class RightFactory extends InstructionFactory {

    @Override
    public Instruction create() {
        return new Right();
    }
}
