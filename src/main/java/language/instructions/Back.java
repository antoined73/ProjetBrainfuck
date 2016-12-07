package language.instructions;

//import
import computationalModel.Memory;
import language.Instruction;
import language.KeyWord;

/**
 * Class that represent BACK Brainfuck Instruction
 * 
 * @author  Alexis Deslandes
 * @version 2016.10.26
 */

public class Back extends Instruction {
     
     private int pointerJump;
     private int instructionPosition;
     /**
     * Back Constructor
     *
     * To know what position in the List is occupied by this Instruction.
     * @param instructionPosition : the position in the List
     */
     public Back(int instructionPosition){
     	this.instructionPosition=instructionPosition;
     }


    /**
     * apply BACK Instruction on pointerInstruction
     *
     * if the pointed case of Memory is not empty we go to the instruction after the JUMP associated else we go to the next instruction in the list.
     * @param m : the Memory
     * @param pointerMemory : the current value of Memory cell pointer
     * @param pointerInstruction : the current value of the cell of the List.
     * @return int : the new pointer in the List of Instruction.
     */
     public int apply(Memory m, int pointerMemory, int pointerInstruction){
     	if(m.getMemoryData(pointerMemory)!=0){
     		return pointerJump+1;
     	}else{
     		return pointerInstruction+1;
     	}
     }

    /**
     *set the attribute PointerJump.
     *
     *@return void
     */
    public void setPointerJump() {
        setPointerJump();
    }

    /**
     *set the attribute PointerJump.
     *
     *@param n : the position in the list of the JUMP instruction associated.
     *@return void
     */
    public void setPointerJump(int n){
        this.pointerJump = n;
    }
    /**
     *get the instruction position in the list.
     *
     *@return int
     */
    public int getInstructionPosition(){
        return this.instructionPosition;
    }

    /**
     * Returns the KeyWord associated with this instruction.
     * @return the KeyWord associated.
     */
    @Override
    public KeyWord getKeyWordAssociated() {
        return KeyWord.BACK;
    }

}
