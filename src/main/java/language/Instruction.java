package language;

//Imports

import computationalModel.Memory;
import computationalModel.exceptions.CellOverflowException;
import computationalModel.exceptions.LeftOrRightException;
import computationalModel.exceptions.NumberOfLineInputException;

import java.io.IOException;

/**
 * Class that represent an instruction in brainfuck.
 */
public abstract class Instruction{

    /**
     * Verify if a potentialKeyWord is in a good syntax in brainfuck.
     * @param potentialKeyWord The word we'll evaluate.
     * @return The word is valuable or not.
     */
	static public boolean isValuable(String potentialKeyWord){ //true if it's a short or long keyWord
		return KeyWord.isKeyWord(potentialKeyWord);
	}

	/**
	 * Returns the KeyWord associated with this instruction.
	 * @return the KeyWord associated.
	 */
	public abstract KeyWord getKeyWordAssociated();

    /**
     * Method that will apply the the wanted modification to the memory.
     * @param m The memory.
     * @param pointerMemory The pointer of the memory.
     * @param pointerInstruction The pointer of the instruction.
     * @return The pointer of instruction incremented or decremented.
     */
	public abstract int apply(Memory m,int pointerMemory, int pointerInstruction) throws CellOverflowException, LeftOrRightException, IOException, NumberOfLineInputException;
}