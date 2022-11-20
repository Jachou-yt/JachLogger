import fr.jachou.jachlogger.JachLogger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class Main {

    private static Main instance;
    private static JachLogger jachLogger = new JachLogger();

    public static void main(String[] args) {
        try {
            getImage();
        } catch (Exception e) {
            jachLogger.error("test", e);
        }
    }

    public static Image getImage() throws IOException {
        InputStream inputStream = instance.getClass().getClassLoader().getResourceAsStream("test");
        return ImageIO.read(inputStream);
    }
}
