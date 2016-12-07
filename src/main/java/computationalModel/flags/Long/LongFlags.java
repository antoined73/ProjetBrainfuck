package computationalModel.flags.Long;

import computationalModel.ArgsManager;
import computationalModel.exceptions.DuplicateFlagException;
import computationalModel.flags.Flags;
import interpreter.ProgramInterpreter;

/**
 * Created by Thomas TETU on 04/12/2016.
 */
public class LongFlags implements Flags {

    private ProgramInterpreter programInterpreter;

    /**
     * LongFlags Constructor
     *
     * Instanciates interpreters for the Rewrite, Check and Translate option.
     *
     * @param programInterpreter
     */

    public LongFlags(ProgramInterpreter programInterpreter){
        this.programInterpreter = programInterpreter;
    }

    /**
     * This constructor is just used for the trace option (that is not an interpretation option)
     */

    public LongFlags() {
    }

    /**
     * This method adds interpreters to the list in the argsManager called in parameter
     * It says also that the brainf*ck file won't be executed.
     *
     * @param argsManager
     * @throws DuplicateFlagException
     */

    @Override
    public void setFlagContent(ArgsManager argsManager) throws DuplicateFlagException {
        argsManager.addInterpreter(programInterpreter);
        argsManager.setExecute_program(false);
    }
}
