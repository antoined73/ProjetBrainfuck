package computationalModel.exceptions;
/**
*Exception that precise if there are problems with the instructions incr or decr.
 * @author AlexisDeslandes
* @version 2016.10.26
*/
public class CellOverflowException extends Exception {

    /**
     * The message Error that will be print.
      */
    private String message;

	/**
     * Exception constructor
     *
     * Store a message bounded to this exception
     * @param msg : a message that helps found the source of the problem
     */
	public CellOverflowException(String msg){
        this.message = msg;
	}

	/**
     * getteur of exception message
     *
     * @return the exception message
     */
	@Override
	public String getMessage(){
		return message;
	}


}
