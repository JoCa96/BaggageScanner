package main;

import java.io.FileInputStream;
import java.util.Properties;

public enum Configuration {
    instance;
    public String userDirectory = System.getProperty("user.dir");
    public String fileSeparator = System.getProperty("file.separator");
    public ScannerType scannerType = getScannerType();
    public String pathToJar = userDirectory + fileSeparator + scannerType + fileSeparator  + "Component.jar";

    public ScannerType getScannerType() {
        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(userDirectory + fileSeparator + "configuration/configuration.props");
            properties.load(fileInputStream);
            fileInputStream.close();
            if (properties.getProperty("scannerType").equals("BoyerMoore"))
                return ScannerType.BoyerMoore;
            else if (properties.getProperty("scannerType").equals("KnuthMorrisPratt"))
                return ScannerType.KnuthMorrisPratt;
            else
                return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}