//Imports

import computationalModel.ArgsManager;
import computationalModel.Catcher;
import computationalModel.Memory;
import computationalModel.Metrics;
import computationalModel.flags.FlagsReader;
import interpreter.ProgramInterpreter;
import interpreter.reader.ProgramReader;
import language.Instruction;

import java.util.List;

/**
 * Main class of the program.
 * 
 * @author  Alexis Deslandes, Antoine Dezarnaud, Thomas Têtu
 * @version 2016.10.20
 */
public class Main{

	 /**
     * main method.
     *
     * Get the tab of arguments and send it to ArgsManager.
     * Then run the ProgramReader to interpret the .bf file given.
     * Or rewrite it if it was demanded.
     * In all cases, this method should catch ALL Exceptions
 	 * and give the exception that occurred to Catcher to deal with it.
     * 
     * @param args : The arguments given
     *
     */
	public static void main(String[] args){
		try{
			Metrics.EXEC_TIME = System.currentTimeMillis();
			FlagsReader flagsReader = new FlagsReader(args);//Line of command process
			ArgsManager manager = flagsReader.getArgsManager();
			Memory memory = new Memory(); //Instanciation of memory
			List<ProgramInterpreter> programInterpreterList = manager.getProgramInterpreterList();
			ProgramReader programReader = manager.createProgramReader();
			List<Instruction> instructionList = programReader.read();
			Metrics.PROG_SIZE = instructionList.size();
			for(ProgramInterpreter pi : programInterpreterList){
				pi.interpret(memory,instructionList);
			}
			programReader.closeBuffers();
			Metrics.EXEC_TIME = System.currentTimeMillis() - Metrics.EXEC_TIME - Metrics.WAIT_FOR_INPUT_TIME;
			Metrics.printTheMetricsInConsole();
		}catch (Exception e){
            new Catcher(e).printException();
		}
	}
}

