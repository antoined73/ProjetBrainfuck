package computationalModel.exceptions;
/**
 * Class that represent a pointer out of Memory exception
 * 
 * @author  Alexis Deslandes
 * @version 2016.10.26
 */
public class LeftOrRightException extends Exception {
	/**
	*The error message.
	*/
	private String message;

	/**
	*LeftOrRightException constructor
	*
	* Store a message bounded to this exception
    * @param msg : a message that helps found the source of the problem
	*/
	public LeftOrRightException(String msg){
        this.message = msg;
	}
	/**
    * Getter of exception message
    *        
    * @return the exception message
    */	
	public String getMessage(){
		return message;
	}

}
