package computationalModel.flags.Short;

import computationalModel.ArgsManager;
import computationalModel.exceptions.DuplicateFlagException;
import computationalModel.exceptions.IncorrectUseOfFlagsException;

/**
 * Created by Thomas TETU on 04/12/2016.
 */
public class Path extends ShortFlags {

    public Path(String filePath) throws IncorrectUseOfFlagsException {
        super(filePath);
    }

    @Override
    public void setFlagContent(ArgsManager argsManager) throws DuplicateFlagException {

        if (!argsManager.isHas_Path()) {
            argsManager.setDefaultFilePath(filePath);
            argsManager.setHas_path(true);
        }
        else throw new DuplicateFlagException("-p");
    }
}

