package interpreter.reader.preProcess;

import computationalModel.exceptions.PreProcessException;

import java.util.Map;


class LongConfig implements DefineConfig {
    @Override
    public String saveInstruction(String line,Map<String,String> macros,int lineNumber) throws PreProcessException {
        String listInstruction = "";
        String[] lineSplit = line.split("\\s+");
        String nameMacroUsed = lineSplit[0];
        if (macros.containsKey(nameMacroUsed)){
            int countMacro = Integer.parseInt(lineSplit[1]);
            for (int i=0;i<countMacro;i++){
                listInstruction += macros.get(nameMacroUsed);
            }
        }else{
            throw new PreProcessException(line,lineNumber,"Problem in longConfig : saveInstruction.");
        }
        return listInstruction;
    }
}
