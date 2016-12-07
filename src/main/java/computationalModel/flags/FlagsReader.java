package computationalModel.flags;

import computationalModel.ArgsManager;
import computationalModel.exceptions.DuplicateFlagException;
import computationalModel.exceptions.IncorrectUseOfFlagsException;
import computationalModel.flags.Long.CheckFlag;
import computationalModel.flags.Long.RewriteFlag;
import computationalModel.flags.Long.TraceFlag;
import computationalModel.flags.Long.TranslateFlag;
import computationalModel.flags.Short.Input;
import computationalModel.flags.Short.Output;
import computationalModel.flags.Short.Path;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Thomas TETU on 04/12/2016.
 */
public class FlagsReader {

     private ArrayList<Flags> flagList= new ArrayList<>();
     private ArgsManager argsManager;

    /**
     * FlagsReader Constructor
     *
     * Takes all the arguments passed in parameter (String tab) and fills a list of instanciated according to the argument.
     * The order of the argument has no incidence on the execution of the program.
     * Then it instanciates an argsManager with that list.
     *
     * @param args
     * @throws IOException
     * @throws DuplicateFlagException
     * @throws IncorrectUseOfFlagsException
     */

     public FlagsReader(String[] args) throws IOException, DuplicateFlagException, IncorrectUseOfFlagsException {
          for (int i = 0; i < args.length; i++) {
               try {
               switch (args[i]) {
                         case "-p":
                              flagList.add(new Path(args[++i]));
                              break;
                         case "-i":
                              flagList.add(new Input(args[++i]));
                              break;
                         case "-o":
                              flagList.add(new Output(args[++i]));
                              break;
                         case "--translate":
                              flagList.add(new TranslateFlag());
                              break;
                         case "--rewrite":
                              flagList.add(new RewriteFlag());
                              break;
                         case "--check":
                              flagList.add(new CheckFlag());
                              break;
                         case "--trace":
                              flagList.add(new TraceFlag());
                              break;
                         default:
                              throw new IncorrectUseOfFlagsException("Not a flag referenced");
               }
               } catch (ArrayIndexOutOfBoundsException e) {
                    throw new IncorrectUseOfFlagsException("-p filename");
               }
          }
          argsManager = new ArgsManager(flagList);
     }

     public ArrayList<Flags> getFlagList(){
          return flagList;
     }

    public ArgsManager getArgsManager() {
        return argsManager;
    }
}

