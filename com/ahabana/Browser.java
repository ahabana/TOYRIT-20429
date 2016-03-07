
package com.ahabana;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class Browser
{
	// instance variable
	protected WebDriver driver;

	public Browser()
	{
		// no constructor
	}

	// setter for driver
	public void setDriver(WebDriver driver)
	{
		this.driver = driver;
	}
	
	// getter for driver
	public WebDriver getDriver()
	{
		return this.driver;
	}

	// changes zipcode
	public void zipChanger(String zipcode)
	{
        // landing
        String url = "http://tstcpd201.toyota.com";
    
        // xpaths
        String your_location = ".//button[@data-target='#tcom-nav-zip-flyout']";
        String zip_input = ".//input[@data-error-message='Enter a zipcode.']";
        // String submit = ".//a[contains(.,'Submit')]";
        String submit = ".//*[@id='tcom-nav-zip-flyout']/div[1]/div/div/a";
        String camry_all_access = ".//img[contains(@src,'access.jpg')]";
    
        // landing page
        driver.get(url);
    
        // change zipcode
        driver.findElement(By.xpath(your_location)).click();
        driver.findElement(By.xpath(zip_input)).sendKeys(zipcode);
        driver.findElement(By.xpath(submit)).click();

		// wait for page
		try
		{
			Thread.sleep(2000L);	
		}
		catch (Exception e)
		{
			org.testng.Assert.fail();
		}
	}

	// validate presence of camry image	
	public void validateCamry(String zipcode)
	{
        // xpaths
        String camry_all_access = ".//img[contains(@src,'access.jpg')]";
    
        // refresh
        driver.navigate().refresh();
			
        // validate camry all access image
        if ( driver.findElement(By.xpath(camry_all_access)).isDisplayed() )
        {
            System.out.print(zipcode + " ");
            System.out.println("Passed");
        }
        else
        {
            System.out.print(zipcode + " ");
            System.out.println("Failed");
			
            // fail test case
            org.testng.Assert.fail();
			
            // take screenshot
            // TODO:
        }
	}
	
	public void close()
	{
		driver.close();
	}
}
