package language.instructions;

import computationalModel.Memory;
import computationalModel.Metrics;
import computationalModel.exceptions.CellOverflowException;
import computationalModel.exceptions.NumberOfLineInputException;
import language.Instruction;
import language.KeyWord;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class that represent a In instruction.
 */
public class In extends Instruction {
    /**
     * Where we look for the input.
     */
	private BufferedReader load;

    /**
     * The constructor of the class In.
     * @param load The location of the input.
     */
	public In(BufferedReader load) {
		this.load=load;
	}

    /**
     * Take the number in input and set it in the memory according to the pointer of memory.
     * We stop the metric execution time if the input takes place in the terminal.
     * @param m The memory
     * @param pointerMemory The pointer of the memory.
     * @param pointerInstruction The current pointer of the instruction.
     * @return the incremented pointer of instruction.
     * @throws CellOverflowException When the input is >255 or <0.
     * @throws NumberOfLineInputException Current line is null.
     * @throws IOException Problem with the BufferedReader.
     */
	public int apply(Memory m, int pointerMemory, int pointerInstruction) throws CellOverflowException,NumberOfLineInputException,IOException { // Changer le nom de IncrOrDecrException
		int input;
		if(load==null){
			input = manageConsole();
		}else{				
            input = manageBuffered();
		}
		m.setMemoryData(pointerMemory, input);	
		return pointerInstruction+1;	
	}

	private int manageConsole(){
        int first = 0;
        int input;
        Scanner scan = new Scanner(System.in);
        long timeBeforeInput = System.currentTimeMillis();
        input=(int) scan.nextLine().charAt(first);
        long timeAfterInput = System.currentTimeMillis();
        Metrics.WAIT_FOR_INPUT_TIME += timeAfterInput-timeBeforeInput;
        return input;
    }

    private int manageBuffered() throws IOException, NumberOfLineInputException {
        int input;
        String currentLine = load.readLine();
        if (currentLine!= null){
            input = (int) currentLine.charAt(0);
        }else{
            throw new NumberOfLineInputException();
        }
        return input;
    }

    /**
     * Returns the KeyWord associated with this instruction.
     * @return the KeyWord associated.
     */
    @Override
    public KeyWord getKeyWordAssociated() {
        return KeyWord.IN;
    }
}
