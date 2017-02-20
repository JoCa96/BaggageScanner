package main;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

@SuppressWarnings({"rawtypes", "unchecked"})
public class Application {
    private Object port;

    public static void main(String... args) {
        Application application = new Application();
        application.createBaggageScanner();
        System.out.println("b in abcdf: " + application.execute("abcdf", "b"));
        System.out.println("x in abcdf: " + application.execute("abcdf", "x"));
    }

    public void createBaggageScanner() {
        Object instance;
        try {
            /*
                Initialization
             */
            System.out.println("pathToJar\t: " + Configuration.instance.pathToJar);
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
            port = clazz.getDeclaredField("port").get(instance);
            System.out.println("Port\t\t\t: " + port.hashCode());
        } catch (Exception e) {
            System.out.println("Something went terribly wrong!");
            System.out.println(e.getMessage());
            System.out.println("---------------------------");
            e.printStackTrace();
        }
    }

    public boolean execute(String haystack,String needle) {
        Object result = null;
        try {
            Method method = port.getClass().getMethod("search", String.class, String.class);
            result = method.invoke(port, haystack, needle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (Boolean) result;
    }
}