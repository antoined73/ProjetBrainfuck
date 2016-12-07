package computationalModel.flags;

import computationalModel.ArgsManager;
import computationalModel.exceptions.DuplicateFlagException;
import computationalModel.exceptions.IncorrectUseOfFlagsException;

/**
 * Created by Thomas TETU on 06/12/2016.
 */
public interface Flags {
    /**
     * setFlagContent Method
     *
     * Takes an argsManager in parameter and set the content of the flag in the corresponding attribute
     *
     * @param argsManager
     * @throws DuplicateFlagException
     * @throws IncorrectUseOfFlagsException
     */

    void setFlagContent(ArgsManager argsManager) throws DuplicateFlagException, IncorrectUseOfFlagsException;
}
