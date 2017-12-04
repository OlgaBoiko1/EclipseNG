package uk.co.eclipse.billing.ngtesting.https.libs;

import org.apache.log4j.Logger;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


public class Utils {
    private Logger log;

    public Utils() {
        log = Logger.getLogger(getClass());
    }

    /*    Taking screenshot into .//target// + pathToScreenShot
        @param pathToScreenShot
    */

    public void screenShot(String pathToScreenShot) {
        try{
            BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(image, "jpg", new File(pathToScreenShot));
            log.info("Screenshot: " + pathToScreenShot);
            }
        catch(Exception e){
            log.info("Unable to write image to file: " + e.getMessage());
            }
    }

}

