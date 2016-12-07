package interpreter.reader;

/**
 * Class that represent a line read in the file .bf
 * @author Alexis Deslandes
 */
public class FileLine {
    /**
     * The line read in the file.
     */
    protected String line;

    /**
     * Constructor of the file line.
     * @param line The current line.
     */
    public FileLine(String line){
        this.line = line;
    }

    /**
     * Method that get the line.
     * @return The line.
     */
    public String getLine() {
        return line;
    }

    /**
     * Method that remove the comment from a line.
     */
    protected void removeComment(){
        if (line.contains("#")){
            line = line.substring(0,line.indexOf("#"));
        }
    }

    /**
     * Method that delete the space at the begin and the end of the line.
     */
    protected void toTrim(){
        line = line.trim();
    }





}
