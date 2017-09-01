package org.mobAuto.mobileAutomation.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
/**
 * This class is used to take a db connection
 * @author gurushant
 *
 */
public class DbUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getDbCon());
	}
	private static Connection dbCon=null;
	public static Connection getDbCon()
	{
		if(dbCon!=null)
		{
			return dbCon;
		}
		else
		{
			Properties prop= AutoProperties.getProperties();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				dbCon=DriverManager.getConnection(  
				prop.getProperty("db.conStr"),prop.getProperty("db.userName"),prop.getProperty("db.password"));  
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}
		return dbCon;
	}

}
