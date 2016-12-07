package language.instructions;

//Imports

import computationalModel.Memory;
import computationalModel.exceptions.CellOverflowException;
import language.Instruction;
import language.KeyWord;

/**
 * Class that represent INCR Brainfuck Instruction
 * 
 * @author  Alexis Deslandes
 * @version 2016.10.20
 */
public class Increment extends Instruction {

	/**
     * apply INCR Instruction on Memory
     *
     * Increment pointed Memory cell by 1.
     * @param m : the Memory
     * @param pointerMemory : the current value of Memory cell pointer
     * @param pointerInstruction : the current value of the cell of the List.
     * @return int : the new pointer in the List of Instruction.
     */
	public int apply(Memory m, int pointerMemory,int pointerInstruction)throws CellOverflowException {
		m.incrMemoryData(pointerMemory);
		return pointerInstruction+1;
	}

	/**
	 * Returns the KeyWord associated with this instruction.
	 * @return the KeyWord associated.
	 */
	@Override
	public KeyWord getKeyWordAssociated() {
		return KeyWord.INCR;
	}

	
}
