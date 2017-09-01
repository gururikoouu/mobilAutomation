package org.mobAuto.mobileAutomation.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
/**
 * This class is used to load the locator from db.
 * @author gurushant
 *
 */
public class Locators {
	private static Map<String, String>locators=null;
	public static Map<String,String>loadLocators()
	{
		if(locators!=null)
		{
			return locators;
		}
		else
		{
			locators=new HashMap<String, String>();
			Connection con=DbUtil.getDbCon();
			try {
				Statement stmt=con.createStatement();
				ResultSet rSet= stmt.executeQuery("select name,locator from locators");
				while(rSet.next())
				{
					locators.put(rSet.getString(1), rSet.getString(2));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return locators;
	}
}
