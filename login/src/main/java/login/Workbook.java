package login;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Workbook {
	public  ArrayList<String> getData(String Testcases ) throws IOException {
		ArrayList<String> a=new ArrayList<String>();
		FileInputStream fil=new FileInputStream("F:\\Suchitra\\Selenium\\workbook\\Datadriven.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fil);
		int nsheets=wb.getNumberOfSheets();
		for(int i=0;i<nsheets;i++) {
			if(wb.getSheetName(i).equalsIgnoreCase("TC FKrt")) {
				XSSFSheet sheet=wb.getSheetAt(i);
				Iterator<Row> rows=sheet.rowIterator();
				Row firstrow=rows.next();
				Iterator<Cell> cell=firstrow.cellIterator();
				int k=0;
				int col=0;
				while(cell.hasNext()) {
					Cell value=cell.next();
					if(value.getStringCellValue().equalsIgnoreCase("TC name"))
							{
							col=k;
							}
							k++;
				}
				while(rows.hasNext()) {
					Row r=rows.next();
					if(r.getCell(col).getStringCellValue().equalsIgnoreCase("Flipkart")) 
					{
						Iterator<Cell> celll=r.cellIterator();
						celll.next();
						while(celll.hasNext())
						{
							Cell hjk=celll.next();
							switch(hjk.getCellType())
							{
													
							case NUMERIC:
								a.add(NumberToTextConverter.toText(hjk.getNumericCellValue()));
								break;
							case STRING:
								a.add(hjk.getStringCellValue());
							}
						}
					}
				}
				}
		}
		
		return a;
	}
}
