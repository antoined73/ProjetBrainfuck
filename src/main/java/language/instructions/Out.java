package language.instructions;

import computationalModel.Memory;
import language.Instruction;
import language.KeyWord;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Class that represent a OUT instruction.
 * @author DeslandesAlexis
 */
public class Out extends Instruction {
    /**
     * Represent the location where we'll save the cell of the memory we want to print.
     */
	private BufferedWriter saveAs;

    /**
     * Constructor of the class Out.
     * @param saveAs The location of the printed cell.
     */
	public Out(BufferedWriter saveAs){
		this.saveAs=saveAs;
	}

    /**
     * Methods that will print out the contenue of the memory cell pointed.
     * @param m The memory.
     * @param pointerMemory The pointer of the memory.
     * @param pointerInstruction The pointer of the instruction.
     * @return The pointer of instruction incremented.
     * @throws IOException Problem with the write method of the BufferedWriter.
     */
	@Override
	public int apply(Memory m, int pointerMemory, int pointerInstruction) throws IOException{
		char toPrint = (char)m.getMemoryData(pointerMemory);
		if (saveAs!=null){
			saveAs.write(toPrint);
		}else{
			System.out.println(toPrint);	
		}	
		return pointerInstruction+1;		
	}

	/**
	 * Returns the KeyWord associated with this instruction.
	 * @return the KeyWord associated.
	 */
	@Override
	public KeyWord getKeyWordAssociated() {
		return KeyWord.OUT;
	}
	
}
