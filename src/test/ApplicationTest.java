package test;

import main.Application;
import main.Configuration;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import static org.junit.Assert.assertEquals;

public class ApplicationTest {
    @Test
    public void testScanner() {
        Application app = new Application();
        app.createBaggageScanner();
        String text = "ABCDE";
        String a = "A";
        String b = "X";
        String c = "E";
        Boolean test = app.execute(text, a);
        assertEquals(test,true);
        assertEquals(app.execute(text, b),false);
        assertEquals(app.execute(text,c),true);
    }
}

