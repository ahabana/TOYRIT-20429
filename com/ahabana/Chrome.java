
package com.ahabana;

import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Chrome extends Browser
{
	// constructor
	public Chrome()
	{
		// call parent
		super();

		// paths
		String key = "webdriver.chrome.driver";
		String path = "/Users/ahabana/dropbox/20151005/mac/chromedriver";
	
		// setup chrome
		System.setProperty(key, path);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.setDriver(driver);
	}
}
