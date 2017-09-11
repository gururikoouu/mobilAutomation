package org.mobAuto.mobileAutomation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class reads properties.
 * @author gurushant
 *
 */
public class AutoProperties {

	private static Properties prop = null;	
	public static Properties getProperties()
	{
		try
		{
			if(prop!=null)
			{
				return prop;
			}
			else
			{
				prop=new Properties();
				InputStream inputStream= new FileInputStream("config/automation.properties");

				if (inputStream != null) {
					prop.load(inputStream);
				} 
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return prop;
	}

	public static void main(String[] args) {
		AutoProperties db=new AutoProperties();
		db.getProperties();
	}

}
