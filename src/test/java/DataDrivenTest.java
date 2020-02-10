import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@SuppressWarnings("unused")
public class DataDrivenTest {

	
	@SuppressWarnings("deprecation")
	public ArrayList<String> getData(String testname) throws IOException {
		// create an array list .it accepts only string
				ArrayList<String> array = new ArrayList<String>();
				
				
				
				// creating an object for FileInputStream class
				FileInputStream fis = new FileInputStream("C:\\Users\\soumya balu\\workspace\\datadriventest\\demotest.xlsx");

				// creating object for XSSFWorkbook class
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
				// get the count of sheets
				int sheets = workbook.getNumberOfSheets();
				// iterate to get the required sheet
				for (int i = 0; i < sheets; i++) {
					if (workbook.getSheetName(i).equalsIgnoreCase("testdata1")) {

						XSSFSheet sheet = workbook.getSheetAt(i);

						// Identify the TestCases column by scanning the entire first row

						Iterator<Row> rows = sheet.iterator();// sheet is collection of rows
						Row firstrow = rows.next();
						Iterator<Cell> cell = firstrow.cellIterator();// row is collection of cells
						int k = 0;
						int column = 0;
						while (cell.hasNext()) {
							Cell value = cell.next();
							if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {
								// desired column will be that
								column = k;

							}
							k++;
						}
						System.out.println(column);
						// once the TestCases column is identified, scan for the entire column to get
						// the Purchase TestCase row
						  while (rows.hasNext()) 
						  {
							Row r = rows.next();
							if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testname)) {
								// once you get the Purchase TestCase then pull all data and feed it into our
								// java test cases
								Iterator<Cell> ci = r.cellIterator();
								while (ci.hasNext())
								{
								 	Cell c=ci.next();
									
								if(c.getCellTypeEnum()==CellType.STRING) {
									
								
									//System.out.println(ci.next().getStringCellValue());
									//sending the below code to the arraylist with object array
									array.add(c.getStringCellValue());
								}
								else
								{
									array.add(NumberToTextConverter.toText(c.getNumericCellValue()));
								}
							
						  
					}
								}

							}
						
						
					
					
					}
					}
				
				return array;
	
	
	
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		}

	}


