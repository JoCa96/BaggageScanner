"%JAVA%\bin\javac" -Xlint:all -g:none -classpath build -d build src\IBaggageScanner.java
"%JAVA%\bin\javac" -Xlint:all -g:none -classpath build -d build src\KnuthMorrisPratt.java

cd build
"%JAVA%\bin\jar" -cvf Component.jar IBaggageScanner.class
"%JAVA%\bin\jar" -uvf Component.jar KnuthMorrisPratt.class
"%JAVA%\bin\jar" -uvf Component.jar KnuthMorrisPratt$Port.class

move Component.jar ..\Component.jar

pause