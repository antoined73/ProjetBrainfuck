package computationalModel;
//Import
import computationalModel.exceptions.CellOverflowException;
import computationalModel.exceptions.LeftOrRightException;

import java.lang.StringBuilder;
/**
* The memory class that represent the 30 000 cells of memory which can take value an int between 0 and 255.
*
* @author AlexisDeslandes,ThomasTetu and AntoineDezarnaud
* @version 2016.10.26
*/
public class Memory {
	/**
	*The minimum that can take a cell.
	*/
	private final int MIN_CELL = 0;
    /**
     * The maximum that can take a cell.
     */
	private final int MAX_CELL = 255;
    /**
     * The number of cell.
     */
	private final int MEMORY_SIZE = 30000;
    /**
     * The array of cell.
     */
	private int[] memory;
    /**
     * The pointer to the memory.
     */
	private int p;
	/**
	* Memory Constructor
	*
	* Initiate the memory to 0 with the good constant.
	*/
	public Memory(){
		this.memory=new int[MEMORY_SIZE];
		for (int i=0;i<memory.length;i++){
			this.memory[i]=0;
		}
		this.p=0;
	}	
	/**
	* Return the memory.
	*
	*@int[] : The memory as an array.
	*/
	public int[] getMemory(){
		return this.memory;
	}
	/**
	* Return the content of a cell.
	*
	* @param p : the index of the cell you want.
	*@return int : the content of the cell.
	*/
	public int getMemoryData(int p){
		Metrics.DATA_READ++;
		return this.memory[p];
	}
	/**
	* Set the cell you want with the param p.
	*
	*@param p : the number of the cell you want to set.
	*@param number : the number you want to set in the cell.
	*@return void
	*/	
	public void setMemoryData(int p,int number) throws CellOverflowException {
		if((number>=MIN_CELL)&&(number<=MAX_CELL) && memory[p]!=number){
			Metrics.DATA_WRITE++;
			this.memory[p] = number;
		}else{
			throw new CellOverflowException("Cell Overflow at c"+p+" = "+number);
		}
	}
	public void decrMemoryData(int p) throws CellOverflowException {
		int cellCountaint = memory[p];
		setMemoryData(p,--cellCountaint);
	}
	public void incrMemoryData(int p) throws CellOverflowException {
		int cellCountaint = memory[p];
		setMemoryData(p,++cellCountaint);
	}
	/**
	* Get the pointer
	*
	* @return int : the pointer.
	*/
	public int getPointer(){
		return this.p;
	}	
	/**
	* Set the position of the pointer.
	*
	*@param number : the new position of the pointer.
	*@return void.
	*/	
	public void setPointer(int number) throws LeftOrRightException{
		if((number>=0)&&(number<=MAX_CELL-1) && number!=p){
			Metrics.DATA_MOVE++;
			this.p=number;
		}else{
			throw new LeftOrRightException("Pointer out of memory with p = "+number);
		}
	}
	/**
	* Return the description of the memory. All the cells which are not equals to 0 are printed.
	*
	* @return : The description.
	*/
	public String toString(){
		StringBuilder s = new StringBuilder();
		for(int i = 0;i<memory.length;i++){
			if(memory[i] != 0){
				s.append("c"+i+" : "+this.memory[i]+"\n");
			}
		}
		return s.toString();
	}
}