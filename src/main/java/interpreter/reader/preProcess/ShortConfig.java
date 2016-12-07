package interpreter.reader.preProcess;

import java.util.Map;
/**
 * Created by Desla on 06/12/2016.
 */
public class ShortConfig implements DefineConfig {
    @Override
    public String saveInstruction(String line,Map<String,String> macros,int lineNumber) {
        line = line.replaceAll("\\s+","");
        return line;
    }
}
