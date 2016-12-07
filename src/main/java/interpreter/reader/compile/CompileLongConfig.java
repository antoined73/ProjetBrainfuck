package interpreter.reader.compile;

import computationalModel.exceptions.KeyWordNotFoundException;
import language.Instruction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


class CompileLongConfig implements CompileConfig {


    @Override
    public List<Instruction> saveInstruction(String line, Map<String, String> macro, int instructionCount, BufferedReader load, BufferedWriter saveAs) throws KeyWordNotFoundException {
        List<Instruction> list = new ArrayList<>();
        list.add(CompileLine.convert(line,load,saveAs,instructionCount));
        return list;
    }
}
