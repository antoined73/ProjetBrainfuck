package computationalModel.exceptions;

/**
 * Exception that show the current word is not a known keyword.
 * @author AntoineDezarnaud
 */
public class KeyWordNotFoundException extends Exception {
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
    public KeyWordNotFoundException(String msg){
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
