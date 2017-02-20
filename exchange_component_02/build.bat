"%JAVA%\bin\javac" -Xlint:all -g:none -classpath build -d build src\IBaggageScanner.java
"%JAVA%\bin\javac" -Xlint:all -g:none -classpath build -d build src\KnuthMorrisPratt.java

cd build
"%JAVA%\bin\jar" -cvf KnuthMorrisPratt.jar IBaggageScanner.class
"%JAVA%\bin\jar" -uvf KnuthMorrisPratt.jar KnuthMorrisPratt.class
"%JAVA%\bin\jar" -uvf KnuthMorrisPratt.jar KnuthMorrisPratt$Port.class

move KnuthMorrisPratt.jar ..\KnuthMorrisPratt.jar

pause