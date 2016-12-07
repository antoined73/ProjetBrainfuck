package language.instructions;

//Imports

import computationalModel.Memory;
import computationalModel.exceptions.CellOverflowException;
import language.Instruction;
import language.KeyWord;

/**
 * Class that represent DECR Brainfuck Instruction
 * 
 * @author  Alexis Deslandes
 * @version 2016.10.20
 */
public class Decrement extends Instruction {

	/**
     * apply DECR Instruction on Memory
     *
     * Decrement pointed Memory cell by 1.
     * 
     * @param m : the Memory
     * @param pointerMemory : the current value of Memory cell pointer
     * 
     * @return void
     */
	@Override
	public int apply(Memory m, int pointerMemory, int pointerInstruction) throws CellOverflowException {
		m.decrMemoryData(pointerMemory);
          return pointerInstruction+1;		
	}

	/**
	 * Returns the KeyWord associated with this instruction.
	 * @return the KeyWord associated.
	 */
	@Override
	public KeyWord getKeyWordAssociated() {
		return KeyWord.DECR;
	}

}
