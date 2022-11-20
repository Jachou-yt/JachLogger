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

    public JachLogger(LoggerFile loggerFile) {
        try {
            fileAdded = true;
            logFile = loggerFile;
            loggerFile.write("Logger initialized.");
            info(startLogger + "Logger initialized.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JachLogger() {
        try {
            fileAdded = false;
            info(startLogger + "Logger initialized.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void error(String message, Exception e) {
        try {
            if (fileAdded) {
                logFile.write(startLogger + message + e);
            }
            System.out.println(startLogger + message + " " + e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void info(String message) {
        try {
            if (fileAdded) {
                logFile.write(startLogger + message);
            }
            System.out.println(startLogger + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
