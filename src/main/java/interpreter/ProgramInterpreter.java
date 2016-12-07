package interpreter;

//Imports
import computationalModel.Memory;
import computationalModel.exceptions.*;
import language.Instruction;

import java.io.IOException;
import java.util.List;

/**
 * An interface that allows us to interpret differently a list of instructions.
 */
public interface ProgramInterpreter{
    /**
     * Method that interpret a list of instruction dfferently according to the interpreter choosen.
     * @param m The memory.
     * @param listInstruction The list of instruction.
     */
	public void interpret(Memory m, List<Instruction> listInstruction) throws ImageSyntaxException, CellOverflowException,
            LeftOrRightException, NumberOfLineInputException, IOException, JumpException;
}