package org.mobAuto.mobileAutomation;

import java.io.File;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.mobAuto.mobileAutomation.utils.Locator;
import org.mobAuto.mobileAutomation.utils.Locators;
import org.mobAuto.mobileAutomation.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	private Map<String, Locator>locatorMap=Locators.loadLocators();
	private WebDriverUtils webUtils=null;
	public  CalculatorAuto() {
		// TODO Auto-generated constructor stub
		webUtils=new WebDriverUtils();
	}
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
		driver=webUtils.initDriver(deviceName, version, platformName, appPackage, appActivity, remoteUrl);
//        final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
//        System.setProperty(ESCAPE_PROPERTY, "true");
//        
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability("deviceName", deviceName);
//		capabilities.setCapability(CapabilityType.VERSION, version);
//		capabilities.setCapability("platformName", platformName);
//		capabilities.setCapability("appPackage", appPackage);
//		capabilities.setCapability("appActivity", appActivity);
//		try {
//			driver = new RemoteWebDriver(new URL(remoteUrl), capabilities);
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	/**
	 * This is the test method for doing summation.
	 * @param a
	 * @param sum
	 */
	@Test
	public void login()
	{
		WebElement element=webUtils.findElement(driver, "//android.widget.Button[@text='Continue with Facebook']", "xpath");
		System.out.println("Element is =>"+element);
		webUtils.click(driver, locatorMap.get("home.login"));
	}
	
	/**
	 * This method executes after each test method execution.
	 */
	@AfterMethod
	public void tearDown()
	{
		//driver.quit();
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
