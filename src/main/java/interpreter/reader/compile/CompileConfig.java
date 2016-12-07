package interpreter.reader.compile;

import computationalModel.exceptions.KeyWordNotFoundException;
import language.Instruction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.List;
import java.util.Map;

/**
 * Interface which permits us to save a list of Instruction depending on the configuration.
 */
interface CompileConfig {
    /**
     * Method that return the list of instruction contained in a line.
     * @param line The current line.
     * @param macro The map containing the different macro.
     * @param instructionCount The number of instruction we meet before.
     * @param load The file where the input are.
     * @param saveAs The file where we have to put the ouput.
     * @return The list of instruction.
     * @throws KeyWordNotFoundException The keyword is not recognised.
     */
    List<Instruction> saveInstruction(String line, Map<String, String> macro,
                                      int instructionCount, BufferedReader load,
                                      BufferedWriter saveAs) throws KeyWordNotFoundException;
}
