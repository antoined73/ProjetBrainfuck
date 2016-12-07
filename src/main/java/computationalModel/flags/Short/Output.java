package computationalModel.flags.Short;

import computationalModel.ArgsManager;
import computationalModel.exceptions.DuplicateFlagException;
import computationalModel.exceptions.IncorrectUseOfFlagsException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Thomas TETU on 04/12/2016.
 */

public class Output extends ShortFlags {

    File file;
    private BufferedWriter bw;

     public Output(String filePath) throws IOException, DuplicateFlagException, IncorrectUseOfFlagsException {

             file = new File(filePath);
             if (!file.exists()){
                 file.createNewFile();
             }
             bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
    }

    @Override
    public void setFlagContent(ArgsManager argsManager) throws DuplicateFlagException, IncorrectUseOfFlagsException {
        try {
            if (argsManager.getBw() == null) argsManager.setBw(bw);

            else throw new DuplicateFlagException("-o");

        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IncorrectUseOfFlagsException("-o filename");
        }
    }
}
