import fr.jachou.jachlogger.DiscordLogger;
import fr.jachou.jachlogger.JachLogger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class Main {


    public static void main(String[] args) {
        DiscordLogger discordLogger = new DiscordLogger("ODY3MzMzMTU2MDM0MDUyMTE3.GiY8Bo.MGTP46JoJGiKFbk3ZTNCKFLm8qTylMtcUrjs5s", "1027283463390371861");
        System.out.println("test passed");
        discordLogger.sendInfo("test", "1027283463390371861");
    }
}
