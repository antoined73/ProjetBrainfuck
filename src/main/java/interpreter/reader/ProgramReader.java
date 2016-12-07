package interpreter.reader;

import computationalModel.exceptions.*;
import language.Instruction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

/**
 * Class that interpret a .bf file to modify Memory thanks to Instructions
 * 
 * @author  Alexis Deslandes, Antoine Dezarnaud, Thomas Têtu
 * @version 2016.10.20
 */
public abstract class ProgramReader{
	
	//attributes
    String filepath;
	BufferedWriter saveAs;
	BufferedReader load;

	/**
     * ProgramReader constructor 
     *
     * Instanciate the Memory, open .bf file and stores buffers 
     * used to read and write in -i and -o files respectively.
     * 
     * @param filepath : Filepath of the .bf file
     * @param load : Buffer of in file (given after -i flag)
     * @param saveAs : Buffer of out file (given after -o flag)
     *
     */
    ProgramReader(String filepath, BufferedReader load, BufferedWriter saveAs)
	throws IOException {
        this.saveAs = saveAs;
        this.load = load;
        this.filepath = filepath;
    }

	/**
     * Read .bf file
     *
 	 * Create instructions like demands the .bf file.
 	 *
     * @return void
     */
	public abstract List<Instruction> read() throws CellOverflowException,
            LeftOrRightException, NumberOfLineInputException, IOException, ImageSyntaxException, KeyWordNotFoundException, PreProcessException, JumpException, CompileException;

	
	/**
     * Close all buffers opened.
     * this method force child classes to close it.
     */
	public abstract void closeBuffers() throws IOException;

	/**
	 * Close the buffers used for in et out.
	 */
	void closeInAndOutBuffers() throws IOException{
		if (saveAs!=null){
			saveAs.close();
		}
		if (load!=null){
			load.close();
		}
	}

}