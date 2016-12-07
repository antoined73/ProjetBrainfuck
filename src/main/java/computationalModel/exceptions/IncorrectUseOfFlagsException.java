package computationalModel.exceptions;
/**
*Exception that precise if there are problems with the arguments in command line.
* @author Antoine Dezarnaud
* @version 2016.10.26
*/
public class IncorrectUseOfFlagsException extends Exception {
	/**
	*The flag that have issue.
	*/
	private String flag;
	/**
	*IncorrectUseOfFlagsException Constructor
	*
	*Store the flag which has a problem.
	*@param f : the flag with issue.
	*/
	public IncorrectUseOfFlagsException(String f){
		this.flag = f;
	}
	/**
	*Get the error message for the corresponding issue.
	*
	*@return String : the error message.
	*/
	@Override
	public String getMessage(){
		switch(flag){
			case "-p filename": return "Give a .bf filepath after \"-p\" flag.";
			case "no flag":
			case "-p is missing": return "Use -p [file.bf] to use this program.";
			case "-i filename": return "Give an input filepath after \"-i\" flag";
			case "-o filename": return "Give an output filepath after \"-o\" flag";
			case "executive and non executive flags mixed": return "You can't use --translate, --rewrite or --check with others flags than -p flag. ";
			default: return "Wrong flag : "+flag;
		}
	}
}
