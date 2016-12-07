package interpreter.reader.preProcess;

import computationalModel.exceptions.PreProcessException;
import interpreter.reader.FileLine;
import language.Instruction;

import java.util.HashMap;
import java.util.Map;


public class PreProcessLine extends FileLine {

    private String name;
    private String instruction;
    private static final String MACRO_FLAG = "#define ";
    private final String shortConfig = "short";
    private final String longConfig = "long";

    public PreProcessLine(String line, Map<String, String> macros,int lineNumber) throws PreProcessException {
        super(line);
        Map<String, DefineConfig> definesConfig = new HashMap<>();
        completeConfigMap(definesConfig);
        clearLineForMacro();
        constructorName();
        takeOfName();
        String whichConfiguration = determineConfiguration(lineNumber,macros);
        instruction = definesConfig.get(whichConfiguration).saveInstruction(this.line,macros,lineNumber);
    }

    private void completeConfigMap(Map<String,DefineConfig> definesConfig){
        definesConfig.put(shortConfig,new ShortConfig());
        definesConfig.put(longConfig,new LongConfig());
    }

    private String determineConfiguration(int lineNumber, Map<String,String> macros) throws PreProcessException  {
        if (isShortConfig()){
            return shortConfig;
        }else if (isLongConfig(lineNumber,macros)){
            return longConfig;
        }else{
            throw new PreProcessException(line,lineNumber,"Problem in PreProcessLine : determineConfiguration.");
        }
    }

    private boolean isLongConfig(int lineNumber, Map<String,String> macros) throws PreProcessException {
        String[] lineSplit = line.split("\\s+");
        String nameMacro = lineSplit[0];
        if (macros.containsKey(nameMacro)){
            try {
                int countMacro = Integer.parseInt(lineSplit[1]);
            }catch (Exception e){
                throw new PreProcessException(line,lineNumber,"Problem in PreProcessLine : isLongConfig :" +
                        " You should have an int after the name of the macro.");
            }
            return true;
        }else{
            return false;
        }
    }

    private boolean isShortConfig(){
        String newLine;
        newLine = line.replaceAll("\\s+","");
        String[] lineSplit = newLine.split("");
        for (String split : lineSplit){
            if (!Instruction.isValuable(split)) return false;
        }
        return true;
    }

    private void takeOfName(){
        line = line.replaceAll(name,"");
        toTrim();
    }

    private void constructorName(){
        int firstSpace = line.indexOf(" ");
        name = line.substring(0,firstSpace);
    }

    public String getName() {
        return name;
    }

    private void clearLineForMacro() {
        toTrim();
        line = line.substring(MACRO_FLAG.length(), line.length());
        this.removeComment();
        toTrim();
    }

    public String getInstruction() {
        return instruction;
    }
}
