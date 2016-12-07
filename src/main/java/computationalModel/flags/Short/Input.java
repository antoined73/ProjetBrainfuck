package computationalModel.flags.Short;

import computationalModel.ArgsManager;
import computationalModel.exceptions.DuplicateFlagException;
import computationalModel.exceptions.IncorrectUseOfFlagsException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Thomas TETU on 04/12/2016.
 */

public class Input extends ShortFlags {

    private BufferedReader br;

    /**
     *
     * @param filePath
     * @throws FileNotFoundException
     * @throws DuplicateFlagException
     * @throws IncorrectUseOfFlagsException
     */

    public Input(String filePath) throws FileNotFoundException, DuplicateFlagException, IncorrectUseOfFlagsException {
        br = new BufferedReader(new FileReader(new File(filePath)));

    }

    @Override
    public void setFlagContent(ArgsManager argsManager) throws DuplicateFlagException, IncorrectUseOfFlagsException {
        try{

            if(argsManager.getBr() == null) argsManager.setBr(br);
            else throw new DuplicateFlagException("-i");

        } catch (ArrayIndexOutOfBoundsException e){
            throw new IncorrectUseOfFlagsException("-i filename");

        }
    }
}
