import org.junit.Test;

import static org.junit.Assert.*;


public class KnuthMorrisPrattTest {
    @Test
    public void test(){
        KnuthMorrisPratt knuthMorrisPratt = new KnuthMorrisPratt();
        assertEquals(true, knuthMorrisPratt.port.search("jonathank", "a"));
        assertEquals(true, knuthMorrisPratt.port.search("jonathank", "k"));
        assertEquals(false, knuthMorrisPratt.port.search("jonathank", "x"));
    }
}