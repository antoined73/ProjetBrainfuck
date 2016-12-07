package language.instructions.instructionFactory;

import language.Instruction;
import language.instructions.In;

import java.io.BufferedReader;

/**
 * Created by Desla on 01/12/2016.
 */
public class InFactory extends InstructionFactory {

    BufferedReader load;

    public InFactory(BufferedReader load) {
        this.load=load;
    }

    @Override
    public Instruction create() {
        return new In(load);
    }
}
