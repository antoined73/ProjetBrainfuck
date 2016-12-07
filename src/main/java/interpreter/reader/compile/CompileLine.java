package interpreter.reader.compile;

import language.instructions.instructionFactory.InstructionFactory;
import computationalModel.exceptions.CompileException;
import computationalModel.exceptions.KeyWordNotFoundException;
import interpreter.reader.FileLine;
import language.Instruction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class that represent a line in the compile phase.
 * @author Alexis Deslandes
 */
public class CompileLine extends FileLine {
    /**
     * The list of instruction contained in the compile line.
     */
    private List<Instruction> listInstruction;
    /**
     * A kind of config : shortConfig : When the line contains short synthax.
     */
    private final static String shortConfig = "shortConfig";
    /**
     * A kind of config : longConfig : When the line contains long synthax.
     */
    private final static String longConfig = "longConfig";
    /**
     * A kind of config : macroConfig : When the line contains a macro.
     */
    private final static String macroConfig = "macroConfig";

    /**
     * Constructor of the compile line : It saves the list of instruction contained in the current line.
     * @param line The current line.
     * @param macros The Map containing the macros.
     * @param instructionCount The number of instruction already saved.
     * @param load Where the input are.
     * @param saveAs Where we have to save the output.
     * @param lineNumber At which line we are in the file.
     * @throws KeyWordNotFoundException A keyword is not recognised.
     * @throws CompileException The compile phase has not been successfull.
     */
    public CompileLine(String line, Map<String, String> macros,
                       int instructionCount, BufferedReader load,
                       BufferedWriter saveAs, int lineNumber) throws KeyWordNotFoundException, CompileException {
        super(line);
        Map<String,CompileConfig> compileConfigMap = new HashMap<>();
        completeConfigMap(compileConfigMap);
        removeComment();
        toTrim();
        String whichConfig = chooseConfig(lineNumber,macros);
        CompileConfig compileConfig = compileConfigMap.get(whichConfig);
        listInstruction = compileConfig.saveInstruction(this.line,macros,instructionCount,load,saveAs);
    }

    /**
     * Initialise the map of configuration.
     * @param compileConfigMap The map to initialise.
     */
    private void completeConfigMap(Map<String,CompileConfig> compileConfigMap){
        compileConfigMap.put(shortConfig,new CompileShortConfig());
        compileConfigMap.put(longConfig,new CompileLongConfig());
        compileConfigMap.put(macroConfig,new CompileMacroConfig());
    }

    /**
     * Choose in which kind of configuration the line is.
     * @param lineNumber At which line we are in the file.
     * @param macros The Map containing the macros.
     * @return The configuration.
     * @throws CompileException The compile phase has not been successfull, don't recognise the config.
     */
    private String chooseConfig(int lineNumber, Map<String,String> macros) throws CompileException {
        if (Instruction.isValuable(line)){
            return longConfig;
        }else if (isMacroConfig(lineNumber,macros)){
            return macroConfig;
        }else if (isShortConfig()){
            return shortConfig;
        }else{
            throw new CompileException(line,lineNumber,"Problem in CompileLine : chooseConfig.");
        }
    }

    /**
     * Say if the line is in a short config.
     * @return true if the line is in a short config.
     */
    private boolean isShortConfig(){
        if (!Instruction.isValuable(line)){
            String newLine = line.replaceAll("\\s+","");
            String[] lineSplit = newLine.split("");
            for (String split : lineSplit){
                if (!Instruction.isValuable(split)){
                    return false;
                }
            }
        }else{
            return false;
        }
        return true;
    }

    /**
     * Say if the line is in a macro config.
     * @param lineNumber At which line we are in the file.
     * @param macros The Map containing the macros.
     * @return true if the line is in a macro config.
     * @throws CompileException The compile phase has not been successfull.
     */
    private boolean isMacroConfig(int lineNumber, Map<String,String> macros) throws CompileException {
        String[] lineSplit = line.split("\\s+");
        String nameMacro = lineSplit[0];
        if (macros.containsKey(nameMacro)){
            try {
                int macroCount = Integer.parseInt(lineSplit[1]);
            }catch(Exception e){
                throw new CompileException(line,lineNumber,"Problem in CompileLine : " +
                        "isMacroConfig : you need an int after the name of the macro.");
            }
            return true;
        }else{
            return false;
        }
    }

    /**
     * Convert the current word in an instruction.
     * @param word
     * @param load
     * @param saveAs
     * @param instructionCount
     * @return
     * @throws KeyWordNotFoundException
     */
    static Instruction convert(String word, BufferedReader load, BufferedWriter saveAs, int instructionCount) throws KeyWordNotFoundException {
        InstructionFactory insFactory = InstructionFactory.getWhichInstructionFactory(word,load,saveAs,instructionCount);
        return insFactory != null ? insFactory.create() : null;
    }



    public List<Instruction> getInstruction() {
        return listInstruction;
    }
}
