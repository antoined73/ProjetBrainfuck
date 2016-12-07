package language.instructions.instructionFactory;

import computationalModel.exceptions.KeyWordNotFoundException;
import language.Instruction;
import language.KeyWord;

import java.io.BufferedReader;
import java.io.BufferedWriter;

/**
 * Created by Desla on 01/12/2016.
 */
public abstract class InstructionFactory {

    public abstract Instruction create();

    public static InstructionFactory getWhichInstructionFactory(String potentialKeyWord,BufferedReader load,BufferedWriter saveAs,int instructionCount) throws KeyWordNotFoundException {
        switch (KeyWord.getKeyWord(potentialKeyWord)){
            case INCR: return new IncrementFactory();
            case  DECR : return(new DecrementFactory());
            case  LEFT: return(new LeftFactory());
            case  RIGHT : return(new RightFactory());
            case IN : return (new InFactory(load));
            case OUT : return(new OutFactory(saveAs));
            case JUMP : return (new JumpFactory(instructionCount));
            case BACK : return (new BackFactory(instructionCount));
            default : return null;
        }
    }

}
