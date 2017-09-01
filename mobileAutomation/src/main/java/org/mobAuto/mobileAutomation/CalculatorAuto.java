package org.mobAuto.mobileAutomation;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.mobAuto.mobileAutomation.utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * This is the main test class.
 * @author gurushant
 *
 */
public class CalculatorAuto {

	
	private WebDriver driver;
	private Map<String, String>locatorMap=Locators.loadLocators();
	/**
	 * This method gets executed before every method.
	 * @param deviceName
	 * @param version
	 * @param platformName
	 * @param appPackage
	 * @param appActivity
	 * @param remoteUrl
	 */
	@BeforeMethod	
	@Parameters({"deviceName","version","platformName","appPackage","appActivity","remoteUrl"})
	public void setUp(String deviceName,String version,String platformName,String appPackage,String appActivity,
			String remoteUrl)
	{
        final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
        System.setProperty(ESCAPE_PROPERTY, "true");
        
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability(CapabilityType.VERSION, version);
		capabilities.setCapability("platformName", platformName);
		capabilities.setCapability("appPackage", appPackage);
		capabilities.setCapability("appActivity", appActivity);
		try {
			driver = new RemoteWebDriver(new URL(remoteUrl), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	/**
	 * This is the test method for doing summation.
	 * @param a
	 * @param sum
	 */
	@Test(dataProvider="data")
	public void doSum(int a[],int sum)
	{
		driver.findElement(By.xpath(locatorMap.get("home.del"))).click();
		for(int i=0;i<a.length;i++)
		{
			String loc=locatorMap.get("home.buttonTxt");
			driver.findElement(By.xpath(loc.replace("locTxt", Integer.toString(a[i])))).click();
			if(i<a.length-1)
				driver.findElement(By.xpath(locatorMap.get("home.plus"))).click();
		}
		driver.findElement(By.xpath(locatorMap.get("home.equal"))).click();
		String result = driver.findElement(By.className(locatorMap.get("home.editText"))).getText();
		if(Integer.parseInt(result)==sum)
		{
			Reporter.log("Execution is successfull.Actual is  "+sum+",Expected is "+result);
		}
		else
		{
			Reporter.log("Execution is failed.Actual is  "+sum+",Expected is "+result);
			throw new Error();
		}
	}
	
	/**
	 * This method executes after each test method execution.
	 */
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	/**
	 * This is the data provider used to input to the test method.
	 * @return
	 */
	@DataProvider(name="data")
	public static Object[][] getData(){
        int a[]={1,2,3,4};
        int b[]={5,1};
		return new Object[][]{{a,10},{b,10}};
	}

}
