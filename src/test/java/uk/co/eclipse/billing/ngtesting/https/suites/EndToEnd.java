package uk.co.eclipse.billing.ngtesting.https.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import uk.co.eclipse.billing.ngtesting.https.importCDR.ValidUploadZIPFile;
import uk.co.eclipse.billing.ngtesting.https.login.ValidLogOn;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                ValidLogOn.class,
                ValidUploadZIPFile.class
        }
)

public class EndToEnd {
}
