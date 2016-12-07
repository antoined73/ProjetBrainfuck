package computationalModel.flags.Long;

import interpreter.options.Check;

/**
 * Created by Thomas TETU on 05/12/2016.
 */
public class CheckFlag extends LongFlags {
    /**
     * Constructor of the Check flag, that would intanciates a check interpreter
     *
     */
    public CheckFlag(){
        super(new Check());
    }

}
