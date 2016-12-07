package interpreter.reader.compile;

import computationalModel.exceptions.KeyWordNotFoundException;
import language.Instruction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


class CompileShortConfig implements CompileConfig {


    @Override
    public List<Instruction> saveInstruction(String line, Map<String,String> macro, int instructionCount, BufferedReader load, BufferedWriter saveAs) throws KeyWordNotFoundException {

        List<Instruction> listInstruction = new ArrayList<>();
        line = line.replaceAll("\\s+","");
        String[] lineSplit = line.split("");
        for (String currentSplit : lineSplit) {
            listInstruction.add(CompileLine.convert(currentSplit,load,saveAs,instructionCount));
            instructionCount++;
        }
        return listInstruction;
    }
}
