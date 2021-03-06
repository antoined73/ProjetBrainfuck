package language.instructions;

//Imports

import computationalModel.Memory;
import computationalModel.exceptions.LeftOrRightException;
import language.Instruction;
import language.KeyWord;

/**
 * Class that represent LEFT Brainfuck Instruction
 * 
 * @author  Alexis Deslandes
 * @version 2016.10.20
 */
public class Left extends Instruction {
	/**
     * apply left Instruction on Memory
     *
     * Decrement Memory cell pointer by 1.
     * 
     * @param m : the Memory
     * @param pointerMemory : the current value of Memory cell pointer
     * 
     * @return void
     */
	@Override
	public int apply(Memory m, int pointerMemory, int pointerInstruction)throws LeftOrRightException {
		m.setPointer(pointerMemory-1);
		return pointerInstruction+1;
		
	}

	/**
	 * Returns the KeyWord associated with this instruction.
	 * @return the KeyWord associated.
	 */
	@Override
	public KeyWord getKeyWordAssociated() {
		return KeyWord.LEFT;
	}
}
