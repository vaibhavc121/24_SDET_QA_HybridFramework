package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders
{
	// data provider 1

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException
	{
		String path = ".\\testdata\\logindata.xlsx"; // taking xl file from testData

		ExcelUtility xlutil = new ExcelUtility(path);// creating an object for XLUtility

		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);

		String logindata[][] = new String[totalrows][totalcols]; // created for two dimension array which can store

		for (int i = 1; i <= totalrows; i++) // 1--we are ignoring header part of excel //read the data from x1 storing
												// in two deminsional array
		{
			for (int j = 0; j < totalcols; j++) // 0 i is rows j is col
			{
				logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j); // 1,0
				// [i-1]--in xl, we are ignoring header part of excel
			}
		}

		return logindata;// returning two dimension array
	}

	// data provider 2

	@DataProvider(name = "AddressData")
	public String[][] getAddress() throws IOException
	{
		String path = ".\\testdata\\logindata.xlsx"; // taking xl file from testData

		ExcelUtility xlutil = new ExcelUtility(path);// creating an object for XLUtility

		int totalrows = xlutil.getRowCount("Address");
		int totalcols = xlutil.getCellCount("Address", 1);

		String logindata[][] = new String[totalrows][totalcols]; // created for two dimension array which can store

		for (int i = 1; i <= totalrows; i++) // 1--we are ignoring header part of excel //read the data from x1 storing
		// in two deminsional array
		{
			for (int j = 0; j < totalcols; j++) // 0 i is rows j is col
			{
				logindata[i - 1][j] = xlutil.getCellData("Address", i, j); // 1,0
				// [i-1]--in xl, we are ignoring header part of excel
			}
		}

		return logindata;// returning two dimension array

	}
	// data provider 3

	// data provider 4
}
