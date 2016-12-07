package language.instructions.instructionFactory;

import language.Instruction;
import language.instructions.Decrement;

/**
 * Created by Desla on 01/12/2016.
 */
public class DecrementFactory extends InstructionFactory {

    @Override
    public Instruction create() {
        return new Decrement();
    }
}
