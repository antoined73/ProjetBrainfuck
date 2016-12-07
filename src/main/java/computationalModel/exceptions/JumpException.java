package computationalModel.exceptions;

/**
 * Exception that represent a jump Exception.
 * @author AlexisDeslandes
 */
public class JumpException extends Exception {
    /**
     * The error message.
     */
    private String message;

    /**
     * Constructor of the JumpException.
     * @param s The error message.
     */
    public JumpException(String s) {
        this.message = s;
    }

    /**
     * Method that get the errorMessage.
     * @return The error message.
     */
    public String getMessage(){
        return this.message;
    }
}
