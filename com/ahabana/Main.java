
package com.ahabana;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;

public class Main
{	
	private Browser browser = new Firefox();

	@Test( dataProvider="getData" )
	public void test(String zipcode)
	{
		// change zip
		browser.zipChanger(zipcode);

		// validate camry
		browser.validateCamry(zipcode);
	}

	@AfterTest
	public void afterTest()
	{
		// close browser
		browser.close();
	}

	@DataProvider
	public Object[][] getData()
	{
		// create array of zipcodes
		String[] zipcodes = {"90245", "90250", "90251", "90254", "90260", "90261", "90266", "90267", "90277", "90278", "90304", "90310", "90503", "90504", "90509", "90510", "90742", "90743", "92003", "92003", "92007", "92008", "92009", "92010", "92011", "92013", "92014", "92018", "92023", "92024", "92028", "92028", "92029", "92049", "92051", "92052", "92054", "92055", "92056", "92057", "92058", "92067", "92068", "92075", "92078", "92081", "92083", "92084", "92085", "92088", "92088", "92091", "92536", "92543", "92544", "92545", "92546", "92562", "92563", "92564", "92584", "92589", "92590", "92591", "92592", "92593", "92595", "92596", "92605", "92615", "92646", "92647", "92648", "92649", "92672", "92674", "92708", "92728"};

		// create 3d array with zipcodes
		Object[][] data = new Object[zipcodes.length][1];
		
		// add zipcodes to 3d array 
		for (int i = 0, y = zipcodes.length; i < y; i++)
		{
			data[i][0] = zipcodes[i];
		}

		return data;
	}
}
