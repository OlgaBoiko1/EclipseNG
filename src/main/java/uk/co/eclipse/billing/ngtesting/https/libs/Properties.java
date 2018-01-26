package uk.co.eclipse.billing.ngtesting.https.libs;

public class Properties {

    public static String browser = System.getProperty("browser");
    public static String company = System.getProperty("company");
    public static String login = System.getProperty("login");
    public static String password = System.getProperty("password");
    public static String nameDB = System.getProperty("nameDB");
    public static String user_name_DB = System.getProperty("userNameDB");
    public static String user_pass_DB = System.getProperty("userPassDB");

    public static String getCompany(){
        return company;
    }

    public static String getLogin(){
        return login;
    }

    public static String getPassword(){
        return password;
    }

    public static String getNameDB(){
        return nameDB;
    }

    public static String getUserNameDB(){
        return user_name_DB;
    }

    public static String getUserPassDB(){
        return user_pass_DB;
    }

    public static String getBrowser(){
        return browser;
    }
}
