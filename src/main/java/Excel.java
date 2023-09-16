import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	static  String values[][]=new String[2][3];

	public static String[][] data() throws IOException {

		String file = "./src/testdata/data.xlsx";
		XSSFWorkbook wbook = new XSSFWorkbook(file);
		XSSFSheet sheet = wbook.getSheetAt(0);
		for (int i = 1; i < 3; i++) {
			XSSFRow drow = sheet.getRow(i);
			for (int j =0; j < 3; j++) {
				XSSFCell ccell = drow.getCell(j);
				DataFormatter df = new DataFormatter();
				String str1= df.formatCellValue(ccell);
				System.out.println(str1);
				values[i-1][j]= str1;
			} 

		}wbook.close();

		return values;

	}

	public String[][] readExcel() {
		// TODO Auto-generated method stub
		return null;
	}
}
