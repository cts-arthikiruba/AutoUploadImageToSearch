import java.io.IOException;
import java.util.Arrays;



public class automate {

	static String[][] excel_values;

	public void automate(){

		try
		{
			//Object Creation For Excel File
			Excel Excel_Key = new Excel();



			//Object Creation For Registration File
			imageupload obj = new imageupload();




			//Reading Values From Excel
			excel_values = Excel_Key.data();



			int rows = excel_values.length;

			int columns = excel_values[0].length;

			int iter = 0;


			while(iter <= rows){

				String browser_input = excel_values[iter][0];

				String from_date = excel_values[iter][1];

				String to_date = excel_values[iter][2];



				obj.createDriver(browser_input);

				obj.process(from_date,to_date);

				obj.closeBrowser();



				iter++;
			}
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
	}

}
