package esobchak.school21;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Logger {
    public static ArrayList<String> messages = new ArrayList<>();
    private static Logger logger = null;

    Logger(){}

    public static Logger getLogger() {
        if (logger == null)
            logger = new Logger();
        return logger;
    }

    public void addLoggerLine(String message) {
        messages.add(message);
    }

    public void loggerToFile() {
        BufferedWriter bufferedWriter;
        try{
            bufferedWriter = new BufferedWriter(new FileWriter("simulation1.txt"));
            for(String mes : messages){
                bufferedWriter.write(mes + '\n');
                bufferedWriter.flush();
            }
            bufferedWriter.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
