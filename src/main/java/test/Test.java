package test;

import fr.jachou.jachlogger.JachLogger;
import fr.jachou.jachlogger.api.DiscordWebhook;
import fr.jachou.jachlogger.utils.LoggerFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        JachLogger jachLogger = new JachLogger(new LoggerFile("test", "C:\\Users\\matis\\IdeaProjects\\JachLogger\\src\\main\\resources"));
        jachLogger.withDiscordWhebhook("https://discord.com/api/webhooks/1057595680752939079/auEs9nErqLzHVkMqVUTXMBnchw2fepY2mOytsn96wPa06V-EjQngmyN8dMHMDPrOERt7");
        jachLogger.info("test");
        try {
            ImageIO.read(new File("string.txt"));
        } catch (Exception e) {
            jachLogger.error("erreur", e);
        }
    }
}
