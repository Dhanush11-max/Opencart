package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = ".\\testData\\Opencart_LoginData.xlsx";// taking xl file from testData
		ExcelUtility xlutil = new ExcelUtility(path);// creating an object for XLUtility

		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);

		String logindata[][] = new String[totalrows][totalcols]; // created for 2D array which can stored
		for (int i = 1; i <= totalrows; i++) // read the data from xl storing in 2D array
		{
			for (int j = 0; j < totalcols; j++) // i is rows j is col

			{
				logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j); // 1,0
			}
		}
		return logindata;// returning 2D array
	}
}
