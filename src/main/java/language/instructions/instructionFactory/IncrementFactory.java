package language.instructions.instructionFactory;

import language.Instruction;
import language.instructions.Increment;

/**
 * Created by Desla on 01/12/2016.
 */
public class IncrementFactory extends InstructionFactory {

    @Override
    public Instruction create() {
        return new Increment();
    }
}
