package uk.co.eclipse.billing.ngtesting.https.libs;

import org.apache.log4j.Logger;
import org.junit.Assert;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


public class Utils {
    private Logger logger;

    public Utils() {
        logger = Logger.getLogger(getClass());
    }

    /*    Taking screenshot into .//target// + pathToScreenShot
        @param pathToScreenShot
    */

    public void screenShot(String pathToScreenShot) {
        try{
            File file = new File(pathToScreenShot);
            file.mkdirs();
            BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(image, "jpg", file);
            logger.info("Screenshot: " + pathToScreenShot);
            }
        catch(Exception e){
            logger.info("Unable to write image to file: " + e.getMessage());
            }
    }

    public void myAssertTrue(String message, Boolean expectedResult){
        if(!expectedResult){
            logger.error(message);
        }
        Assert.assertTrue(message, expectedResult);
    }

    public void myAssertFail(String message){
        logger.error(message);
        Assert.fail(message);
    }
}

