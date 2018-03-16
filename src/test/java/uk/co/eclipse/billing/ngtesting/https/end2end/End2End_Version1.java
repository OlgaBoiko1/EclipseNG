package uk.co.eclipse.billing.ngtesting.https.end2end;

import org.junit.Before;
import org.junit.Test;
import uk.co.eclipse.billing.ngtesting.https.libs.ConfigData;
import uk.co.eclipse.billing.ngtesting.https.libs.ExcelDriver;
import uk.co.eclipse.billing.ngtesting.https.libs.Properties;
import uk.co.eclipse.billing.ngtesting.https.parent.Parent;

import java.io.IOException;
import java.util.Map;

public class End2End_Version1 extends Parent{
    public String[] cdrFileName;
    public String[] cdrFilterName;
    public String company = Properties.getCompany();
    public String login = Properties.getLogin();
    public String password = Properties.getPassword();
    public int numberOfFiles;
    public ExcelDriver excelDriver;

    public End2End_Version1(){
    }


    @Before
    public void readDataFromExcel() throws IOException {
        //Read data from Excel
        excelDriver = new ExcelDriver();
        Map<String,String> dataSet = excelDriver.getData(ConfigData.getCfgValue("DATA_FILE_PATH") + "testEnd2End.xls","End2End_Version1");
        String listOfFilesAndFilters = dataSet.get("FilesAndFilters");

        //Parse string with Files and Filters which should be uploaded
        String[] parseOfValue = listOfFilesAndFilters.split(";");
        numberOfFiles = parseOfValue.length;
        cdrFileName = new String[numberOfFiles];
        cdrFilterName = new String[numberOfFiles];
        for (int i=0; i < numberOfFiles; i++) {
            cdrFileName[i] = parseOfValue[i].split(",")[0];
            cdrFilterName[i] = parseOfValue[i].split(",")[1];
        }
    }

    @Test
    public void end2end(){
        loginPage.loginUser(company, login, password);
        homePage.navigateToMenuImportCDR();
        for (int i=0; i < numberOfFiles; i++)
        importCDRPage.selectFileIfAbsent(cdrFileName[i],cdrFilterName[i]);
    }

}
