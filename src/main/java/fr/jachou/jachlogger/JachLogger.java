package fr.jachou.jachlogger;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class JachLogger {

    private boolean fileAdded = false;
    private LoggerFile logFile;
    Date today = new Date();
    private DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
            DateFormat.SHORT,
            DateFormat.SHORT);
    private String startLogger = "["+shortDateFormat.format(today)+"] ";

    public JachLogger(LoggerFile loggerFile) throws IOException {
        fileAdded = true;
        logFile = loggerFile;
        loggerFile.write("Logger initialized.");
        info(startLogger + "Logger initialized.");
    }

    public JachLogger() throws IOException {
        fileAdded = false;
        info(startLogger + "Logger initialized.");
    }

    public void error(String message, Error e) throws IOException {
        if (fileAdded) {
            logFile.write(startLogger + message + e);
        }
        System.out.println(startLogger + message + e);
    }

    public void info(String message) throws IOException {
        if (fileAdded) {
            logFile.write(startLogger + message);
        }
        System.out.println(startLogger + message);
    }
}
