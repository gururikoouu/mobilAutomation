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
	private static Map<String, Locator>locators=null;
	public static Map<String,Locator>loadLocators()
	{
		if(locators!=null)
		{
			return locators;
		}
		else
		{
			locators=new HashMap<String, Locator>();
			Connection con=DbUtil.getDbCon();
			try {
				Statement stmt=con.createStatement();
				ResultSet rSet= stmt.executeQuery("select name,locator,type from locators");
				while(rSet.next())
				{
					Locator locObj=new Locator();
					locObj.setLocatorTxt(rSet.getString(2));
					locObj.setType(rSet.getString(3));
					locators.put(rSet.getString(1),locObj);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return locators;
	}
}

