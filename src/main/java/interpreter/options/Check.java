package interpreter.options;

//Imports
import Tools.ListInstructionTools;
import computationalModel.Memory;
import computationalModel.exceptions.*;
import interpreter.ProgramInterpreter;
import language.Instruction;

import java.io.IOException;
import java.util.List;

/**
 * Class that is a kind of Interpretation of the program.
 * @author Alexis Deslandes
 */
public class Check implements ProgramInterpreter {

    /**
     * Interpret the check flag..
     * @param m The memory
     * @param listInstruction The list of Instuction of the program.
     */
	public void interpret(Memory m,List<Instruction> listInstruction) throws ImageSyntaxException, CellOverflowException,
            LeftOrRightException, NumberOfLineInputException, IOException, JumpException {
	 	ListInstructionTools.iswellFormed(listInstruction);
		//if wellFormed, program have to exit silently. Else, an error will be thrown.
	 }
}