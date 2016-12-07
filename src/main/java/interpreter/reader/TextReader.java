package interpreter.reader;
//Imports

import computationalModel.exceptions.*;
import interpreter.reader.compile.CompileLine;
import interpreter.reader.preProcess.PreProcessLine;
import language.Instruction;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class that will deal with the brainfuck file to save macros and the list of instructions.
 *
 * @author AlexisDeslandes, Antoine Dezarnaud, Thomas Tetu
 */
public class TextReader extends ProgramReader{
    /**
     * The file brainfuck.
     */
    private BufferedReader reader;
    /**
     * A map which contains the macros in a string synthax.
     */
    private Map<String,String> macros;
    /**
     * The flag before all the macros.
     */
    private static final String MACRO_FLAG = "#define ";

	/**
	 * Constructor of the TextReader.
	 * @param filepath of the file we want to read
	 * @param load , the bufferedReader we use to read the IN file
	 * @param saveAs, the BufferedWriter we use to write in the OUT file
	 */
	public TextReader(String filepath, BufferedReader load, BufferedWriter saveAs)throws IOException{
		super(filepath,load,saveAs);
        macros = new HashMap<>();
        this.reader = new BufferedReader(new FileReader(new File(filepath)));
	}

	/**
	 * Read the text file and interpret it to add the instructions in the list of Instructions.
	 * @return the list of Instruction
	 */
	public List<Instruction> read() throws CellOverflowException,
            LeftOrRightException, NumberOfLineInputException, IOException, ImageSyntaxException, KeyWordNotFoundException, PreProcessException, JumpException, CompileException {
		List<Instruction> listInstruction;
        int lineNumber = 0;
		//PRE-PROCESSING
		lineNumber = preprocess(lineNumber);
        //COMPILING
		listInstruction= compile(lineNumber);
		//All buffers are closed because they're no needed anymore
		closeBuffers();
		return listInstruction;
	}

	/**
	 * Pre-process method
	 *
	 * Read the first lines of the file beginning with a "#define " in order
	 * to create macros.
     *
     * @return the number of line after the last #define.
	 */
	private int preprocess(int lineNumber) throws IOException, JumpException, KeyWordNotFoundException, NumberOfLineInputException, PreProcessException {
		String currentLine;
        int numberOfCharacterRead = 0;
        while (((currentLine=reader.readLine()) != null)&&((currentLine.contains(MACRO_FLAG))||isAComment(currentLine))){
            lineNumber++;
            if (!isAComment(currentLine)) {
                PreProcessLine preProcessLine = new PreProcessLine(currentLine, macros, lineNumber);
                macros.put(preProcessLine.getName(), preProcessLine.getInstruction());
                numberOfCharacterRead += currentLine.length();
                reader.mark(numberOfCharacterRead);
            }
        }
        try {
            reader.reset();//we go to the last line we were
        }catch(IOException e) { //if there wasn't "#define"
            this.reader = new BufferedReader(new FileReader(new File(filepath)));
        }
        return lineNumber;
	}

    /**
     * Method saying if a line is just a comment.
     * @param line The line to deal with.
     * @return True if a line is just a comment.
     */
	private boolean isAComment(String line){
        line = line.trim();
        return (!line.contains(MACRO_FLAG) && line.charAt(0)=='#');
    }

	/**
	 * Compile method
	 *
	 * Read all the program brainfuck after the pre-process lines
	 * ans create the list of instructions.
	 *@return The list of instruction contained in the file brainfuck.
	 */
	private List<Instruction> compile(int lineNumber) throws IOException, NumberOfLineInputException, JumpException, KeyWordNotFoundException, CompileException {
		String line;
        int instructionCount = 0;
        List<Instruction> listInstruction = new ArrayList<>();
        while (((line = reader.readLine())!=null)){
            lineNumber++;
            if (!isAComment(line)) {
                CompileLine compileLine = new CompileLine(line, macros, instructionCount, load, saveAs, lineNumber);
                listInstruction.addAll(compileLine.getInstruction());
                instructionCount = listInstruction.size();
            }
        }
        return listInstruction;
	}

	/**
	 * Close all the buffers we used.
	 */
    public void closeBuffers() throws IOException {
        if(this.reader != null){
            reader.close();
        }
        closeInAndOutBuffers();
    }

}