package interpreter.options;

//Imports

import Tools.ListInstructionTools;
import computationalModel.Memory;
import computationalModel.Metrics;
import computationalModel.exceptions.*;
import interpreter.ProgramInterpreter;
import language.Instruction;
import observers.Observable;

import java.io.IOException;
import java.util.List;

public class Exec extends Observable implements ProgramInterpreter {
	/*
	Attributes

	@pointerInstruction : Pointing on the instruction to apply
	@logger : the log file containing the trace of execution

	 */

	private int pointerInstruction;


	/**
	 * Exec constructor
	 * Default (without parameter)
	 */
	public Exec(){}


	/**
	 * Method interpret
     * Interpret the Instructions' list taken in parameter, applying it in the memory
	 * @param m The memory.
	 * @param listInstruction The list of instruction.
	 */
	public void interpret(Memory m,List<Instruction> listInstruction) throws ImageSyntaxException, CellOverflowException,
            LeftOrRightException, NumberOfLineInputException, IOException, JumpException {
        ListInstructionTools.fillParamsJumpAndBack(listInstruction);
	 	pointerInstruction = 0;
		int execution_step = 1;
		int memory_pointer;
		while (pointerInstruction != listInstruction.size()){
			memory_pointer = m.getPointer();
			changePointerInstruction(listInstruction.get(pointerInstruction).apply(m,memory_pointer,pointerInstruction));
			setState(execution_step,m,memory_pointer);
			execution_step++;
		}
		System.out.println(m);
	 }

    private void setState(int execution_step, Memory m, int memory_pointer) throws IOException {
        state = execution_step + "-  |  next execution pointer location : "+pointerInstruction+"  |  memory pointer :"+memory_pointer+"\n"+
                m.toString()+"\n";
        notifyAllObservers();
    }

    /**
	 * Method that changes the position of the pointer in the list of Instruction.
	 * @param newLocation the next location of this pointer.
	 */
	 private void changePointerInstruction(int newLocation){
		if (newLocation != pointerInstruction){
			Metrics.EXEC_MOVE++;
			pointerInstruction=newLocation;
		}
	 }
}