package computationalModel.flags.Long;

import interpreter.options.Translate;

/**
 * Created by Thomas TETU on 05/12/2016.
 */
public class TranslateFlag extends LongFlags {
    /**
     * TranslateFlag constructor
     *
     * Instanciates Translate interpreter
     */
    public TranslateFlag(){
        super(new Translate());
    }
}
