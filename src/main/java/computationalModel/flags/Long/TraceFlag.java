package computationalModel.flags.Long;

import computationalModel.ArgsManager;
import computationalModel.exceptions.DuplicateFlagException;

/**
 * Created by Thomas TETU on 05/12/2016.
 */
public class TraceFlag extends LongFlags {

    private boolean with_log;

    /**
     * TraceFlag Constructor
     *
     * Notifying the trace option.
     */

    public TraceFlag() {
        with_log = true;
    }

    /**
     * Sets on the trace option in the argsManager called in parameter.
     *
     * @param argsManager
     * @throws DuplicateFlagException
     */

    @Override
    public void setFlagContent(ArgsManager argsManager) throws DuplicateFlagException {

        if(!argsManager.isWith_log()) argsManager.setWith_log(with_log);
        else throw new DuplicateFlagException("--trace");
    }
}
