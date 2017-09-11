package org.mobAuto.mobileAutomation.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class WebDriverUtils {
	
	private WebDriver driver=null;
	private Wait<WebDriver> wait=null;
	
	
	public WebDriver initDriver(String deviceName,String version,String platformName,String appPackage,
			String appActivity,String remoteUrl)
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
			driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			wait=new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
	
	public WebElement findElement(WebDriver driver,final String locator,String type)
	{
		WebElement element=null;
		if(type.equalsIgnoreCase("xpath"))
		{
			   element = wait.until(new Function<WebDriver, WebElement>() {
				     public WebElement apply(WebDriver driver) {
				       return driver.findElement(By.xpath(locator));
				     }
				   });
		}
		return element;
	}
	
	public void click(WebDriver driver,Locator loc)
	{
		
		WebElement element=findElement(driver, loc.getLocatorTxt(), loc.getType());
		element.click();
	}
	
	

}
