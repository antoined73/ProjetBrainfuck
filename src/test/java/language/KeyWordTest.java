package language;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.security.Key;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Antoine on 12/4/2016.
 */
public class KeyWordTest {

    @Test
    public void getKeyWordWithRightValuesTest() throws Exception {
        assertEquals(KeyWord.getKeyWord("INCR"),KeyWord.INCR);
        assertEquals(KeyWord.getKeyWord("+"),KeyWord.INCR);
        assertEquals(KeyWord.getKeyWord("FFFFFF"),KeyWord.INCR);
        assertEquals(KeyWord.getKeyWord("ffffff"),KeyWord.INCR);

        assertEquals(KeyWord.getKeyWord("-"),KeyWord.DECR);
        assertEquals(KeyWord.getKeyWord("DECR"),KeyWord.DECR);
        assertEquals(KeyWord.getKeyWord("4b0082"),KeyWord.DECR);
        assertEquals(KeyWord.getKeyWord("4B0082"),KeyWord.DECR);

        assertEquals(KeyWord.getKeyWord("<"),KeyWord.LEFT);
        assertEquals(KeyWord.getKeyWord("LEFT"),KeyWord.LEFT);
        assertEquals(KeyWord.getKeyWord("9400d3"),KeyWord.LEFT);
        assertEquals(KeyWord.getKeyWord("9400D3"),KeyWord.LEFT);

        assertEquals(KeyWord.getKeyWord(">"),KeyWord.RIGHT);
        assertEquals(KeyWord.getKeyWord("RIGHT"),KeyWord.RIGHT);
        assertEquals(KeyWord.getKeyWord("0000FF"),KeyWord.RIGHT);
        assertEquals(KeyWord.getKeyWord("0000ff"),KeyWord.RIGHT);

        assertEquals(KeyWord.getKeyWord(","),KeyWord.IN);
        assertEquals(KeyWord.getKeyWord("IN"),KeyWord.IN);
        assertEquals(KeyWord.getKeyWord("FFFF00"),KeyWord.IN);
        assertEquals(KeyWord.getKeyWord("ffff00"),KeyWord.IN);

        assertEquals(KeyWord.getKeyWord("."),KeyWord.OUT);
        assertEquals(KeyWord.getKeyWord("OUT"),KeyWord.OUT);
        assertEquals(KeyWord.getKeyWord("00FF00"),KeyWord.OUT);
        assertEquals(KeyWord.getKeyWord("00ff00"),KeyWord.OUT);

        assertEquals(KeyWord.getKeyWord("["),KeyWord.JUMP);
        assertEquals(KeyWord.getKeyWord("JUMP"),KeyWord.JUMP);
        assertEquals(KeyWord.getKeyWord("FF7F00"),KeyWord.JUMP);
        assertEquals(KeyWord.getKeyWord("ff7f00"),KeyWord.JUMP);

        assertEquals(KeyWord.getKeyWord("]"),KeyWord.BACK);
        assertEquals(KeyWord.getKeyWord("BACK"),KeyWord.BACK);
        assertEquals(KeyWord.getKeyWord("FF0000"),KeyWord.BACK);
        assertEquals(KeyWord.getKeyWord("ff0000"),KeyWord.BACK);
    }

    @Test
    public void isKeyWordOnRightValuesTest() throws Exception {
        assertTrue(KeyWord.isKeyWord("+"));
        assertTrue(KeyWord.isKeyWord("INCR"));
        assertTrue(KeyWord.isKeyWord("FFFFFF"));

        assertTrue(KeyWord.isKeyWord("-"));
        assertTrue(KeyWord.isKeyWord("DECR"));
        assertTrue(KeyWord.isKeyWord("4b0082"));

        assertTrue(KeyWord.isKeyWord("<"));
        assertTrue(KeyWord.isKeyWord("LEFT"));
        assertTrue(KeyWord.isKeyWord("9400d3"));

        assertTrue(KeyWord.isKeyWord(">"));
        assertTrue(KeyWord.isKeyWord("RIGHT"));
        assertTrue(KeyWord.isKeyWord("0000FF"));

        assertTrue(KeyWord.isKeyWord(","));
        assertTrue(KeyWord.isKeyWord("IN"));
        assertTrue(KeyWord.isKeyWord("FFFF00"));

        assertTrue(KeyWord.isKeyWord("."));
        assertTrue(KeyWord.isKeyWord("OUT"));
        assertTrue(KeyWord.isKeyWord("00FF00"));

        assertTrue(KeyWord.isKeyWord("["));
        assertTrue(KeyWord.isKeyWord("JUMP"));
        assertTrue(KeyWord.isKeyWord("FF7F00"));

        assertTrue(KeyWord.isKeyWord("]"));
        assertTrue(KeyWord.isKeyWord("BACK"));
        assertTrue(KeyWord.isKeyWord("FF0000"));
    }

    @Test
    public void isKeyWordOnFalseValuesTest() throws Exception {
        assertFalse(KeyWord.isKeyWord("incr"));
        assertFalse(KeyWord.isKeyWord("decr"));
        assertFalse(KeyWord.isKeyWord("right"));
        assertFalse(KeyWord.isKeyWord("left"));
        assertFalse(KeyWord.isKeyWord("in"));
        assertFalse(KeyWord.isKeyWord("out"));
        assertFalse(KeyWord.isKeyWord("jump"));
        assertFalse(KeyWord.isKeyWord("back"));
    }

    @Test
    public void getPossibleValuesTrueValuesTest() throws Exception {
        List<String> values = Arrays.asList(KeyWord.INCR.getPossibleValues());
        assertTrue(values.contains("+"));
        assertTrue(values.contains("ffffff"));

        values = Arrays.asList(KeyWord.DECR.getPossibleValues());
        assertTrue(values.contains("-"));
        assertTrue(values.contains("4b0082"));

        values = Arrays.asList(KeyWord.RIGHT.getPossibleValues());
        assertTrue(values.contains(">"));
        assertTrue(values.contains("0000ff"));

        values = Arrays.asList(KeyWord.LEFT.getPossibleValues());
        assertTrue(values.contains("<"));
        assertTrue(values.contains("9400d3"));

        values = Arrays.asList(KeyWord.IN.getPossibleValues());
        assertTrue(values.contains(","));
        assertTrue(values.contains("ffff00"));

        values = Arrays.asList(KeyWord.OUT.getPossibleValues());
        assertTrue(values.contains("."));
        assertTrue(values.contains("00ff00"));

        values = Arrays.asList(KeyWord.JUMP.getPossibleValues());
        assertTrue(values.contains("["));
        assertTrue(values.contains("ff7f00"));

        values = Arrays.asList(KeyWord.BACK.getPossibleValues());
        assertTrue(values.contains("]"));
        assertTrue(values.contains("ff0000"));
    }
}