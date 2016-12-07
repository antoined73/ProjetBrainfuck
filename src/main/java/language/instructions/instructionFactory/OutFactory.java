package language.instructions.instructionFactory;

import language.Instruction;
import language.instructions.Out;

import java.io.BufferedWriter;

/**
 * Created by Desla on 01/12/2016.
 */
public class OutFactory extends InstructionFactory {

    BufferedWriter saveAs;

    public OutFactory(BufferedWriter saveAs) {
        this.saveAs=saveAs;
    }

    @Override
    public Instruction create() {
        return new Out(saveAs);
    }
}
