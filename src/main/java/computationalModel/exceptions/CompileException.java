package computationalModel.exceptions;

/**
 * Exception that represent an exception in the compilation.
 * @author AlexisDeslandes
 */
public class CompileException extends ReadException {
    /**
     * The kind of error we had in the compilation.
     */
    private String kind;

    /**
     * Constructor of the CompileException class.
     * @param line The currentLine which throw an exception.
     * @param lineError The number of the line.
     * @param kind Kind of error in the compilation.
     */
    public CompileException(String line, int lineError, String kind) {
        super(line, lineError);
        this.kind = kind;
    }

    /**
     * Get the message to print the exception in terminal.
     * @return The error message.
     */
    public String getMessage(){
        return super.getMessage() + "\n" + kind;
    }
}
