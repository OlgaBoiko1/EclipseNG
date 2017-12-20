package uk.co.eclipse.billing.ngtesting.https.libs;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class DataBaseData {
	Logger logger;
	WebDriver webDriver;
	Database sqlServerDB;
	
	public DataBaseData(WebDriver webDriver){
		this.webDriver = webDriver;
		logger = Logger.getLogger(getClass());
	}

	public String getSomeValue(String someData) throws SQLException, ClassNotFoundException, IOException{
		logger.info("Choose following data from DB: " + someData);
		sqlServerDB = new Database("sqlServer_DB","sqlServer");
		String someValue1 = sqlServerDB.selectValue("select ID from USERS where " + someData  + "");
		logger.info("Data is successfully chosen from DB");
		return someValue1;
	}

	public boolean getIsSysUpdated(String user) throws SQLException, ClassNotFoundException, IOException{
		String query = "SELECT isSysUpdated FROM users WHERE username = '" + user  + "'";
		logger.info("Choose following data from DB: " + query);
		sqlServerDB = new Database("sqlServer_DB","sqlServer");

		//If use function selectValue from DB than following code
		//boolean isSystemUpdated = Boolean.valueOf(sqlServerDB.selectValue(query));

		//If we use function selectTable from DB than following code
		List<ArrayList> isSystemUpdateValues;
		isSystemUpdateValues = sqlServerDB.selectTable(query);
		boolean isSystemUpdated = Boolean.valueOf(isSystemUpdateValues.get(1).get(1).toString());
		logger.info("Data is successfully chosen from DB");
		return isSystemUpdated;
	}
}

