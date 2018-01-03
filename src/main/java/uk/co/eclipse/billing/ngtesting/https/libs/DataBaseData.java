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
		sqlServerDB = new Database("sqlServer_DB","sqlServer");

		//Select customer prefix from the system_settings table (to create correct username)
		String customer_prefix_query = "SELECT customer_prefix FROM system_settings";
		List<ArrayList> customerPrefixValues;
		customerPrefixValues = sqlServerDB.selectTable(customer_prefix_query);
		String customerPrefix = customerPrefixValues.get(1).get(1).toString();

		//If we use function selectTable from DB than following code
		String isSysUpdated_query = "SELECT isSysUpdated FROM users WHERE username = '" + customerPrefix + "_" + user  + "'";
		logger.info("Choose following data from DB: " + isSysUpdated_query);
		List<ArrayList> isSystemUpdateValues;
		isSystemUpdateValues = sqlServerDB.selectTable(isSysUpdated_query);

		boolean isSystemUpdated = Boolean.valueOf(isSystemUpdateValues.get(1).get(1).toString());
		logger.info("Data is successfully chosen from DB");
		return isSystemUpdated;

		//If use function selectValue from DB than following code
		//boolean isSystemUpdated = Boolean.valueOf(sqlServerDB.selectValue(isSysUpdated_query));
	}
}

