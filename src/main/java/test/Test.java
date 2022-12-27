package test;

import fr.jachou.jachlogger.JachLogger;
import fr.jachou.jachlogger.LoggerFile;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        JachLogger jachLogger = new JachLogger(new LoggerFile("test", "C:\\Users\\matis\\IdeaProjects\\JachLogger\\src\\main\\resources"));
        jachLogger.info("test");
    }
}
