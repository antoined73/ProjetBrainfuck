package computationalModel.flags.Long;

import interpreter.options.Rewrite;

/**
 * Created by Thomas TETU on 05/12/2016.
 */
public class RewriteFlag extends LongFlags {
    /**
     * RewriteFlag constructor
     *
     * Instanciates Rewrite interpreter
     */

    public RewriteFlag(){
        super(new Rewrite());
    }
}
