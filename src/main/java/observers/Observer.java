package observers;

import interpreter.options.Exec;

import java.io.IOException;

/**
 * Created by Antoine on 12/4/2016.
 */
public abstract class Observer {
    protected Exec exec;

    public abstract void update() throws IOException;
}