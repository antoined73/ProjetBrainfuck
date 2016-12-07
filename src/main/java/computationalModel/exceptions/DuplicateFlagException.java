package computationalModel.exceptions;

import interpreter.options.Check;
import interpreter.options.Rewrite;
import interpreter.options.Translate;

/**
 * Exception that represent a duplicate flag.
 * @author AntoineDezarnaud
 */
public class DuplicateFlagException extends Exception {
    /**
     * The error Message.
     */
    private  String message;

    /**
     * Constructor of DuplicateFlagException depending on the class of the flag.
     * @param c The flag class.
     */
    public DuplicateFlagException(Class c) {
        if(c.equals(Check.class)){
            this.message = "Flag --check was given twice or more.";
        }else if(c.equals(Rewrite.class)){
            this.message = "Flag --rewrite was given twice or more.";
        }else if(c.equals(Translate.class)){
            this.message = "Flag --translate was given twice or more.";
        }
    }

    /**
     * Constructor of DuplicateFlagException.
     * @param flag The flag in string.
     */
    public DuplicateFlagException(String flag) {
        this.message = "Flag "+flag+" was given twice or more.";
    }

    /**
     * Method that get the error message.
     * @return The error message.
     */
    @Override
    public String getMessage(){
        return message;
    }
}
