package computationalModel;

//Imports

import computationalModel.exceptions.CellOverflowException;
import computationalModel.exceptions.JumpException;
import computationalModel.exceptions.LeftOrRightException;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that deal with every exceptions
 * 
 * References all the exceptions.
 * React differently depends of exception that occured.
 *
 * @author  Antoine Dezarnaud
 * @version 2016.10.20
 */
public final class Catcher {

    private Exception exception;
    private Map<Class,Integer> exitCodeByExceptionClass;

    public Catcher(Exception exception){
        this.exception = exception;
        exitCodeByExceptionClass = new HashMap<>();
        exitCodeByExceptionClass.put(CellOverflowException.class,1);
        exitCodeByExceptionClass.put(LeftOrRightException.class,2);
        exitCodeByExceptionClass.put(FileNotFoundException.class,3);
        exitCodeByExceptionClass.put(JumpException.class,4);
    }
	/**
     * Print the exception
     *
     * If the error message has been initialised we print it.
     * Else we print the stack trace.
     *
     * If we encounter one of the indexed exception in the map we set the exit code.
     */
	public void printException(){
        String errorMessage = exception.getMessage();
        Class exceptionClass = exception.getClass();
        if (errorMessage!=null) System.out.println(errorMessage);
        else exception.printStackTrace();
        if (exitCodeByExceptionClass.containsKey(exceptionClass))
            System.exit(exitCodeByExceptionClass.get(exceptionClass));
	}
}
	