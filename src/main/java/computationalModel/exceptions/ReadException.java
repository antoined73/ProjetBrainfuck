package computationalModel.exceptions;

/**
 * Class that represent a read exception.
 * @author Alexis Deslandes
 */
class ReadException extends Exception {
    /**
     * The current line which is read.
     */
    protected String message;
    /**
     * The number of the current line read.
     */
    private int lineError;

    /**
     * The constructor of the class ReadException.
     * @param message The current line which is read.
     * @param lineError The number of the current line read.
     */
    ReadException(String message, int lineError){
        this.message = message;
        this.lineError = lineError;
    }

    /**
     * Method that get the error message that will be print in the terminal.
     * @return The error message.
     */
    public String getMessage(){
        return "Exception at line " + lineError + " : " + message;
    }
}
