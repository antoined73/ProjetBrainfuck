package computationalModel;
//Imports

import computationalModel.exceptions.DuplicateFlagException;
import computationalModel.exceptions.IncorrectUseOfFlagsException;
import computationalModel.flags.Flags;
import interpreter.ProgramInterpreter;
import interpreter.options.Exec;
import interpreter.reader.ImageReader;
import interpreter.reader.ProgramReader;
import interpreter.reader.TextReader;
import observers.Trace;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that interpret the arguments passed in the command line.
 * 
 * @author  Alexis Deslandes, Antoine Dezarnaud, Thomas Têtu
 * @version 2016.10.26
 */
public class ArgsManager{

	/**
	*Filepath of the file.bf.
	*/
	private String defaultFilePath = "";
    /**
    *The input file with the argument for the IN instruction.
     **/
	private List<ProgramInterpreter> programInterpreterList = new ArrayList<>();
    /**
     * The output file for the IN instruction.
     */
	private BufferedReader br = null;
    /**
     * The input file for the OUT instruction.
     */
	private BufferedWriter bw = null;

    private boolean with_log = false;
    private boolean execute_program = true;
    private boolean has_Path = false;
	/**
	* ArgsManager constructor
	*
	*Take all the flags given by the FlagsReader and interpret them.
	*The order of the argument has no incidence on the execution of the program.
	*@param flagsList : list of flags instanciated before
	*/
	public ArgsManager(ArrayList<Flags> flagsList) throws IncorrectUseOfFlagsException, IOException, DuplicateFlagException {

        readFlagsList(flagsList);

		if(has_Path){
			if(execute_program != programInterpreterList.isEmpty()){
				throw new IncorrectUseOfFlagsException("executive and non executive flagsReader mixed");
			}else if (execute_program) {
				Exec exec = new Exec();
                if(with_log) {
                    Trace trace = new Trace(exec,defaultFilePath.split("\\.")[0]+".log");
                }
                programInterpreterList.add(exec);
            }
		}else {
            throw new IncorrectUseOfFlagsException("-p is missing");
        }
	}


	/**
	* Create the class which will interpret the instruction in the .bf file.
	*
	*@return ProgramReader : the instance of the class ProgramReader which we have complete its attributes.
	*/
	public ProgramReader createProgramReader() throws IOException{
		String fileFormat = defaultFilePath.split("\\.")[1];//We take the format of the given file
		if(fileFormat.equals("bf")){
			return new TextReader(defaultFilePath,br,bw);
		}else if (fileFormat.equals("bmp")){
			return new ImageReader(defaultFilePath,br,bw);
		}else{
			throw new FileNotFoundException("The file you have set after flag -p is neither a .bf nor a .bmp");
		}
	}

    /**
     * Method useful to know if an interpreter is already in the InterpreterList.
     *
     * @param currentInterpreter : The interpreter to add
     * @throws DuplicateFlagException
     */

    public void addInterpreter(ProgramInterpreter currentInterpreter) throws DuplicateFlagException {
        for(ProgramInterpreter in : programInterpreterList){
            if(in.getClass().equals(currentInterpreter.getClass())) throw new DuplicateFlagException(currentInterpreter.getClass());
        }
        programInterpreterList.add(currentInterpreter);
    }

    /**
     * Method that read the list of flags in order to set the argsManager's attributes (DefaultFilePath, each boolean, and fill the interpreters' List);
     *
     * @param flagList : List of flags
     *
     * @throws DuplicateFlagException
     * @throws IncorrectUseOfFlagsException
     * @throws FileNotFoundException
     */

    public void readFlagsList(ArrayList<Flags> flagList) throws DuplicateFlagException, IncorrectUseOfFlagsException, FileNotFoundException {
        for(Flags flag : flagList){

            flag.setFlagContent(this);

        }
    }

    /**
     * GETTERS AND SETTERS
     */

	public List<ProgramInterpreter> getProgramInterpreterList(){
		return programInterpreterList;
	}

    public String getDefaultFilePath() {
        return defaultFilePath;
    }

    public BufferedWriter getBw() {
        return bw;
    }

    public BufferedReader getBr() {
        return br;
    }

    public boolean isWith_log() {
        return with_log;
    }

    public boolean isExecute_program() {
        return execute_program;
    }

    public boolean isHas_Path() {
        return has_Path;
    }

    public void setDefaultFilePath(String defaultFilePath) {
        this.defaultFilePath = defaultFilePath;
    }

    public void setBw(BufferedWriter bw) {
        this.bw = bw;
    }

    public void setBr(BufferedReader br) {
        this.br = br;
    }

    public void setHas_path(boolean has_Path) {
        this.has_Path = has_Path;
    }

    public void setWith_log(boolean with_log) {
        this.with_log = with_log;
    }

    public void setExecute_program(boolean execute_program) {
        this.execute_program = execute_program;
    }

}