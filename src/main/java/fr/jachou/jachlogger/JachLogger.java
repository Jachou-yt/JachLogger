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
    private boolean whebookAdded = false;

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
            info("Logger initialized.");
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
            if (fileAdded && whebookAdded) {
                logFile.write(startLogger + message + e);
                sendWhebhook(message, e);
            } else if (whebookAdded) {
                sendWhebhook(message, e);
            }
            System.out.println(startLogger + message + " " + e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void infoWhitoutFile(String message) {
        System.out.println(startLogger + message);
    }

    public void errorWhitoutFile(String message, Exception e) {
        System.out.println(startLogger + message + " " + e);
    }

    public void info(String message) {
        try {
            if (fileAdded && whebookAdded) {
                logFile.write(startLogger + message);
                sendWhebhook(message);
            } else if (whebookAdded) {
                sendWhebhook(message);
            }
            System.out.println(startLogger + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DiscordWebhook withDiscordWhebhook(String url) {
        whebookAdded = true;
        return discordWebhook = new DiscordWebhook(url);
    }

    public void withDiscordWhebhook(DiscordWebhook dw) {
        discordWebhook = dw;
        whebookAdded = true;
    }

    private void sendWhebhook(String content) throws IOException {
        discordWebhook.addEmbed(new DiscordWebhook.EmbedObject().setTitle("Jachlogger Info").setColor(Color.GRAY).setDescription(content));
        discordWebhook.execute();
    }

    private void sendWhebhook(String content, Exception e) throws IOException {
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
