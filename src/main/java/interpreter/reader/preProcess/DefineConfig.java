package interpreter.reader.preProcess;

import computationalModel.exceptions.PreProcessException;

import java.util.Map;

/**
 * Created by Desla on 06/12/2016.
 */
public interface DefineConfig {

    String saveInstruction(String line, Map<String, String> macros, int lineNumber) throws PreProcessException;

}
