import static org.junit.Assert.*;

public class PortTest {
    @org.junit.Test
    public void test() throws Exception {
        BoyerMoore test = new BoyerMoore();
        assertEquals(test.port.search("ABC", "A"), true);
        assertEquals(test.port.search("ABC", "D"), false);
    }

}