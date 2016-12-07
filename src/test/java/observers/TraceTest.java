package observers;

import interpreter.options.Exec;
import org.junit.Test;

/**
 * Created by Antoine on 12/4/2016.
 */
public class TraceTest {
    @Test
    public void updateTest() throws Exception {
        Exec exec = new Exec();
        Trace trace = new Trace(exec,"test.log");
        exec.state = "test";
        trace.update();
        exec.state = "test2";
    }
}