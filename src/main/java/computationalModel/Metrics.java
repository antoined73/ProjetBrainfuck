package computationalModel;

/**
 * Class that keep the differents metrics in the program.
 * @author : Alexis Deslandes
 */
public class Metrics {
    /**
     * The size of the program.
     */
    public static int PROG_SIZE=0;
    /**
     * The time of execution of the program.
     */
    public static long EXEC_TIME;
    /**
     * The time we wait during the waiting of input.
     */
    public static long WAIT_FOR_INPUT_TIME=0;
    /**
     * How many times we move the execution pointer.
     */
    public static int EXEC_MOVE=0;
    /**
     * How many times we move the data pointer.
     */
    static int DATA_MOVE=0;
    /**
     * How many times we write in the memory.
     */
    static int DATA_WRITE=0;
    /**
     * How many times we read the memory.
     */
    static int DATA_READ=0;

    /**
     * Return the metrics in String.
     * @return The metrics readable.
     */
    private static String toStrings(){
        return "PROG_SIZE = " + PROG_SIZE + "\n" +
                "EXEC_TIME = " + EXEC_TIME + "ms" + "\n" +
                "WAIT_FOR_INPUT_TIME = " + WAIT_FOR_INPUT_TIME + "ms" + "\n" +
                "EXEC_MOVE = " + EXEC_MOVE + "\n" +
                "DATA_MOVE = " + DATA_MOVE + "\n" +
                "DATA_WRITE = " + DATA_WRITE + "\n" +
                "DATA_READ = " + DATA_READ;
    }

    /**
     * Print the metrics String in the console.
     */
    public static void printTheMetricsInConsole(){
        System.out.println(toStrings());
    }
}
