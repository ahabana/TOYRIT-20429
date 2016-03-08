
package com.ahabana;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

public class Browser
{
	// instance variable
	protected WebDriver driver;
    
    // xpaths
    String your_location = ".//button[@data-target='#tcom-nav-zip-flyout']";
    String zip_input = ".//input[@data-error-message='Enter a zipcode.']";
    String submit = ".//a[@class='tcom-submit active']";
    String camry_all_access = "//a[contains(.,'Camry All-Access')]";
    String expected = "https://ssl.toyota.com/all-access/camry/home";
    
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
        StringBuilder url = new StringBuilder();
        url.append("http://tstcpd201.toyota.com/");
        url.append("?zipcode=");
        url.append(zipcode);
        
        System.out.print(url.toString() + " ");
        driver.get(url.toString());
	}

	// validate camry redirect
	public void validateCamry(String zipcode)
	{
        // click camry tile
        try
        {
            driver.findElement(By.xpath(camry_all_access)).click();
        }
        catch (Exception e)
        {
            System.out.print("Failed");
            System.out.println();
            org.testng.Assert.fail();
        }
        
        // get url
        String url = driver.getCurrentUrl();
        
        // check if click worked
        if ( url.equals(expected) )
        {
            System.out.print("Passed");
        }
        
        System.out.println();
	}
	
	public void close()
	{
		driver.close();
	}
}
