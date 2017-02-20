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

    private Object port;
    public void createBaggageScanner() {
        Object instance;
        try {
            /*
                Initialization
             */
            System.out.println("pathToJar : " + Configuration.instance.pathToJar);
            URL[] urls = {new File(Configuration.instance.pathToJar).toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, Application.class.getClassLoader());
            /*
                Load Class dynamically
             */
            Class clazz = Class.forName(Configuration.instance.scannerType.toString(), true, urlClassLoader);
            System.out.println("Loaded Class\t: " + clazz.toString());
            /*
                Get instance and his port
             */
            instance = clazz.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            Object port = clazz.getDeclaredField("port").get(instance);
            System.out.println("Port\t\t\t: " + port.hashCode());
        } catch (Exception e) {
            System.out.println("Something went terribly wrong!");
            System.out.println(e.getMessage());
            System.out.println("---------------------------");
            e.printStackTrace();
        }
    }

    public boolean execute(String haystack,String needle) {
        boolean result = false;
        try {
            Method method = port.getClass().getMethod("search", String.class, String.class);
            result = (Boolean)method.invoke(port, haystack, needle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    @Test
    public void testScanner(){
        String text = "ABCDE";
        String a = "A";
        String b = "X";
        assertEquals(execute(text,a),true);
        assertEquals(execute(text,b),false);
    }
}