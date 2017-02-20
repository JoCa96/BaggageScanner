import static org.junit.Assert.*;

/**
 * Created by Filip on 20.02.2017.
 */
public class PortTest {
    @org.junit.Test
    public void test() throws Exception {
        BoyerMoore test = new BoyerMoore();
        assertEquals(test.port.search("ABC","A"),true);
        assertEquals(test.port.search("ABC","D"),false);
    }

}