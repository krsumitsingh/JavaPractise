import java.io.FileInputStream;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


public class ReadExcel {

	public static void main(String[] args) throws InvalidFormatException, Exception {
		// create file input stream object for the excel sheet
		String path = "C:\\Sumit\\TestData\\Read Excel.xlsx";
		FileInputStream fis;
		
		fis = new FileInputStream(path);
        // create object for work book
		Workbook wb = WorkbookFactory.create(fis);
		//create object for sheet present in excel using Workbook object 'wb'
		Sheet sheet = wb.getSheet("Sheet1");
		//create object for row present in sheet using Sheet object 'sheet'
		Row row = sheet.getRow(0);
		//create object for cell present in row using Row object 'row'
		Cell cell = row.getCell(0);
		//print the value present in the excel sheet
		System.out.println("The text is: "+cell.getStringCellValue());

	}
	
}
