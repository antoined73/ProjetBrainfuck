package observers;

import interpreter.options.Exec;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Antoine on 12/4/2016.
 */
public class Trace extends Observer{

    private Exec subject;
    private BufferedWriter logger = null;

    /**
     * Constructor of Trace.
     * @param subject the observable object.
     * @param filepath the filepath of logger.
     */
    public Trace(Observable subject, String filepath) throws IOException {
        this.subject = (Exec) subject;
        this.subject.addObserver(this);
        File file = new File(filepath);
        this.logger = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
    }

    /**
     * Observer has been notified by observable.
     * Time to get state and write it.
     */
    @Override
    public void update() throws IOException {
        String state = (String) subject.getState();
        logger.write(state);
        logger.flush();
    }
}

