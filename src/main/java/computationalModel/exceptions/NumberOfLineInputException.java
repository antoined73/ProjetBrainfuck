package computationalModel.exceptions;
/**
*Exception which said that the input file has not enough argument to complete all the in instruction in the bf file.
*
*@author AlexisDeslandes
*/
public class NumberOfLineInputException extends Exception {
	/**
	*The message that will be print in the command line to show the type of error.
	*/
	private String message;
	/**
	* NumberOfLineInputException Constructor
	*
	* Give the message to the attributes.
	*/
	public NumberOfLineInputException(){
		this.message="Error with the IN instruction : the input file has not enough line to complete all the IN instruction";
	}
	/**
	* Get the error message.
	*
	*@return String : the error message.
	*/
	public String getMessage(){
		return this.message;
	}
}
