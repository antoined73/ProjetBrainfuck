package interpreter.options;

//Imports

import computationalModel.Memory;
import computationalModel.exceptions.CellOverflowException;
import computationalModel.exceptions.ImageSyntaxException;
import computationalModel.exceptions.LeftOrRightException;
import computationalModel.exceptions.NumberOfLineInputException;
import interpreter.ProgramInterpreter;
import language.Instruction;
import language.KeyWord;

import java.io.IOException;
import java.util.List;

/**
 * Class that interpret the rewrite Flag.
 */
public class Rewrite implements ProgramInterpreter {

    /**
     * Interpret the rewrite flag, rewrite the program in shortened syntax.
     * @param m The memory
     * @param listInstruction The list of Instruction
     * @throws ImageSyntaxException
     * @throws CellOverflowException
     * @throws LeftOrRightException
     * @throws NumberOfLineInputException
     * @throws IOException
     */
	public void interpret(Memory m,List<Instruction> listInstruction) throws ImageSyntaxException, CellOverflowException,
	 LeftOrRightException, NumberOfLineInputException, IOException{
		StringBuilder s = new StringBuilder();
		for(Instruction ins : listInstruction){ //For each instruction
			KeyWord keyword = ins.getKeyWordAssociated();
			s.append(keyword.toShortSyntax());
		}
		System.out.println(s);
	 }

	
}