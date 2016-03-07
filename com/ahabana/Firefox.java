
package com.ahabana;

import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class Firefox extends Browser
{
	public Firefox()
	{
		super();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.setDriver(driver);
	}
}
