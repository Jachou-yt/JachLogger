import fr.jachou.jachlogger.JachLogger;
import fr.jachou.jachlogger.LoggerFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        LoggerFile loggerFile = new LoggerFile("test", "C:\\Users\\matis\\IdeaProjects\\JachLogger\\src\\main\\resources");

        JachLogger jachLogger = new JachLogger(loggerFile);

        jachLogger.info("test");
        jachLogger.info("aaa");
        jachLogger.info("bad");

    }
}
