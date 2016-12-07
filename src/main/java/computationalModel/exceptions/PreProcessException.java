package computationalModel.exceptions;

/**
 *Class that represent a preProcess Exception.
 * @author AlexisDeslandes
 */
public class PreProcessException extends ReadException {
    /**
     * The kind of preprocess exception.
     */
    private String kind;

    /**
     * Constructor of the preprocessException.
     * @param line The currentLine in preProcess.
     * @param lineError The number of currentLine in the file.
     * @param kind The kind of preprocess exception.
     */
    public PreProcessException(String line, int lineError, String kind) {
        super(line, lineError);
        this.kind = kind;
    }

    /**
     * Method that get the error message that will be print in the terminal.
     * @return The error message.
     */
    public String getMessage(){return super.getMessage() + "\n" + kind;}
}
