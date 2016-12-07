package interpreter.reader.compile;

import computationalModel.exceptions.KeyWordNotFoundException;
import language.Instruction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


class CompileMacroConfig implements CompileConfig {


    @Override
    public List<Instruction> saveInstruction(String line, Map<String, String> macro, int instructionCount, BufferedReader load, BufferedWriter saveAs) throws KeyWordNotFoundException {
        List<Instruction> instructionList = new ArrayList<>();
        String nameOfMacro = getNameMacro(line);
        String[] instructionBrut = getInstructionBrut(nameOfMacro,macro);
        int countExecuteMacro = getMacroCount(line);
        for (int i=0;i<countExecuteMacro;i++){
            instructionList.addAll(convertMap(instructionBrut,instructionCount,load,saveAs));
            instructionCount += instructionList.size();
        }
        return instructionList;
    }



    private List<Instruction> convertMap(String[] lineSplit, int instructionCount, BufferedReader load, BufferedWriter saveAs) throws KeyWordNotFoundException {
        List<Instruction> list = new ArrayList<>();
        for (String instruction : lineSplit){
            list.add(CompileLine.convert(instruction,load,saveAs,instructionCount));
            instructionCount++;
        }
        return list;
    }



    private String getNameMacro(String line){
        String[] lineSplit = line.split("\\s+");
        return lineSplit[0];
    }



    private String[] getInstructionBrut(String nameOfMacro, Map<String,String> macro){
        String listInstructionInString = macro.get(nameOfMacro);
        return listInstructionInString.split("");
    }



    private int getMacroCount(String line){
        String[] lineSplit = line.split("\\s+");
        return Integer.parseInt(lineSplit[1]);
    }
}
