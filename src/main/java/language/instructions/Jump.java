package language.instructions;

//import
import computationalModel.Memory;
import language.Instruction;
import language.KeyWord;

/**
 * Class that represent JUMP Brainfuck Instruction
 * 
 * @author  Alexis Deslandes
 * @version 2016.10.26
 */

public class Jump extends Instruction {
     private int pointerBack;
     private int instructionPosition;
     /**
     * Jump Constructor
     *
     * To know what position in the List is occupied by this Instruction.
     * @param instructionPosition : the position in the List
     */
     public Jump(int instructionPosition){
          this.instructionPosition=instructionPosition;
     }
     /**
     *set the attribute PointerBack.
     *
     *@param n : the position in the list of the BACK instruction associated.
     *@return void
     */
     public void setPointerBack(int n){
          this.pointerBack = n;
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
     * apply JUMP Instruction on pointerInstruction
     *
     * if the pointed case of Memory is empty we go to the instruction after the BACK associated else we go to the next instruction in the list.
     * @param m : the Memory
     * @param pointerMemory : the current value of Memory cell pointer
     * @param pointerInstruction : the current value of the cell of the List.
     * @return int : the new pointer in the List of Instruction.
     */
     public int apply(Memory m, int pointerMemory, int pointerInstruction){
          if (m.getMemoryData(pointerMemory) ==0){
               return pointerBack+1;
          }else{
               return pointerInstruction+1;
          }
     }

     /**
      * Returns the KeyWord associated with this instruction.
      * @return the KeyWord associated.
      */
     @Override
     public KeyWord getKeyWordAssociated() {
          return KeyWord.JUMP;
     }
}
