package Tools;

import computationalModel.exceptions.JumpException;
import language.Instruction;
import language.instructions.Back;
import language.instructions.Jump;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Class that is a tool to manipulate the list of instruction.
 * @author Alexis Deslandes
 */
public class ListInstructionTools {

    /**
     * Fill the parameters of Instruction Jump and Back
     *
     * Take the List of Instruction, select Jump and Back, and fill for each Instruction his corresponding instruction.
     * In fact, we need to know for a jump Instruction where is the Back instruction.
     *
     */
    public static void fillParamsJumpAndBack(List<Instruction> listInstruction) throws  JumpException {
        int current=0; //Position in the List
        List<Instruction> jumpTable = getJumpTable(listInstruction);
        //Create a list with only the JUMP and BACK instruction(LinkedList to allow to remove).
        if (iswellFormed(jumpTable)){
            while (jumpTable.size() != 0){ //We'll remove element of the list each time we meet a BACK just after a JUMP.
                if (bound(current,current+1,jumpTable)){
                    Jump j = (Jump)jumpTable.get(current);
                    Back b = (Back)jumpTable.get(current+1);
                    j.setPointerBack(b.getInstructionPosition());
                    b.setPointerJump(j.getInstructionPosition());
                    //These line permit to set the pointer of each instruction with their corresponding pointer of JUMP or BACK.
                    jumpTable.remove(current+1);
                    jumpTable.remove(current);
                    //Then we remove these instruction from the list.
                    current=0;
                    //Go back to the first case of the List.
                }else{
                    current++;
                }
            }
        }
    }

    /**
     * Method that says if two instruction(jump and back) in a list of instruction are linked.
     * @param i The index of the jump
     * @param j The index of the back.
     * @param jumpTable The jump table with only jump and back.
     * @return True if the instruction are linked.
     */
    private static boolean bound(int i, int j, List<Instruction> jumpTable){
        return jumpTable.get(i) instanceof Jump && jumpTable.get(j) instanceof Back;
    }

    /**
     * Method that gives the jump table from a list of instruction.
     * @param listInstruction A random list of instruction.
     * @return The jump table of the list of instruction.
     */
    private static List<Instruction> getJumpTable(List<Instruction> listInstruction){
        return new LinkedList<>
                (Arrays.asList(listInstruction.stream().
                        filter(ins -> ins instanceof Jump ||ins instanceof Back).
                        toArray(Instruction[]::new)));
    }

    /**
     *Verify if the program is well formed.
     *
     *Take the list of Instruction of Jump and Back and verify if the number of Jump and Back are the same.
     *Also verify if a back is call without a jump before.
     *All we need it's to count the number of loopsOpened.
     *In the process, if this number is negative that means there is a back called before a jump.
     *After all instructions, the number of loopsOpened should be equal to 0.
     *
     *@param list : the list of Instruction composed as Jump and Back.
     *
     *@return boolean : is well formed or not.
     */
    public static boolean iswellFormed(List<Instruction> list) throws JumpException {
        int loopsOpened = 0;
        for( Instruction ins : list){ //For each instruction
            if(ins instanceof Jump){
                loopsOpened++; //We increment the number of loops Opened if it's a Jump
            }else if( ins instanceof Back){
                loopsOpened--;//We decrement the number of loops Opened if it's a Back
            }
            if(loopsOpened<0){ //If true,means that there is too much backs
                throw new JumpException("You instanciated a BACK before a JUMP");
            }
        }
        //We seen all instructions, loopsOpened should be equal to 0
        if(loopsOpened>0){ //If true, means that there is too much jumps
            throw new JumpException("There are not the same number of JUMP and BACK instruction");
        }else{ //Everything is okay
            return true;
        }
    }



}
