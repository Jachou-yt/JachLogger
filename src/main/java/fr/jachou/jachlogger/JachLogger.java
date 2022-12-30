package fr.jachou.jachlogger;

import fr.jachou.jachlogger.api.DiscordWebhook;
import fr.jachou.jachlogger.utils.LoggerFile;

import java.awt.*;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class JachLogger {

    /*
    Boolean
     */
    private boolean fileAdded = false;
    private static boolean whebookAdded = false;

    /*
    Utils
     */
    private LoggerFile logFile;
    private DiscordWebhook discordWebhook;

    /*
    Simple date
     */
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
            infoWithoutWebhook("Logger initialized.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JachLogger(LoggerFile loggerFile, DiscordWebhook discordWebhook) {
        try {
            fileAdded = true;
            logFile = loggerFile;
            loggerFile.write("Logger initialized.");
            infoWithoutWebhook("Logger initialized.");
            whebookAdded = true;
            this.discordWebhook = discordWebhook;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JachLogger(LoggerFile loggerFile, String discordWebhook) {
        try {
            fileAdded = true;
            logFile = loggerFile;
            loggerFile.write("Logger initialized.");
            whebookAdded = true;
            this.discordWebhook = new DiscordWebhook(discordWebhook);
            infoWithoutWebhook("Logger initialized.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JachLogger() {
        try {
            fileAdded = false;
            infoWithoutWebhook(startLogger + "Logger initialized.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void error(String message, Exception e) {
        try {
            if (fileAdded && whebookAdded) {
                logFile.write(startLogger + message + e);
                sendWebhook(message, e);
            } else if (whebookAdded) {
                sendWebhook(message, e);
            }
            System.out.println(startLogger + message + " " + e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void infoWhitoutFile(String message) {
        if (whebookAdded) {
            System.out.println(startLogger + message);
            try {
                sendWebhook(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(startLogger + message);
        }
    }

    public void errorWhitoutFile(String message, Exception e) {
        if (whebookAdded) {
            System.out.println(startLogger + message + " " + e);
            try {
                sendWebhook(message, e);
            } catch (IOException ex) {
                e.printStackTrace();
            }
        } else {
            System.out.println(startLogger + message + " " + e);
        }
    }

    public void info(String message) {
        try {
            if (fileAdded && whebookAdded) {
                logFile.write(startLogger + message);
                sendWebhook(message);
            } else if (whebookAdded) {
                sendWebhook(message);
            } else if (fileAdded) {
                logFile.write(startLogger + message);
            }
            System.out.println(startLogger + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void removeWebhook() { whebookAdded = false; }

    public void removeFile() { fileAdded = false; }

    public void deleteFile() {
        fileAdded = false;
        logFile.getFile().delete();
    }

    private void sendWebhook(String content) throws IOException {
        discordWebhook.addEmbed(new DiscordWebhook.EmbedObject().setTitle("Jachlogger Info").setColor(Color.GRAY).setDescription(content));
        discordWebhook.execute();
    }

    private void infoWithoutWebhook(String content) {
        if (fileAdded) {
            try {
                logFile.write(startLogger + content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(startLogger + content);
    }

    private void sendWebhook(String content, Exception e) throws IOException {
        discordWebhook.addEmbed(new DiscordWebhook.EmbedObject().setTitle("Jachlogger Error").setColor(Color.GRAY).setDescription(content + ".  Exception : " + e.getMessage()));
        discordWebhook.execute();
    }

    /*
    Getter
     */
    public LoggerFile getLogFile() {
        return logFile;
    }

    public DiscordWebhook getDiscordWebhook() {
        return discordWebhook;
    }


}
