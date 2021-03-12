import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

interface ExcelConverter{
	public void convertToExcel(String str,String str1);
}

public class XMLtoExcel implements ExcelConverter{

	private static XMLtoExcel obj;
	//public static void main(String[] args) throws Exception {

	@Override
	public void convertToExcel(String str, String str1) {
		try {
			createXMLtoExcelFile(str, str1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void createXMLtoExcelFile(String filename,String xmlFile) throws Exception {
		//String filename = "D:\\Excelfiles\\xmlToexcel1.xlsx";
		FileOutputStream fileOut = new FileOutputStream(filename); 
		XSSFWorkbook workbook= new XSSFWorkbook();
		XSSFSheet sheet= workbook.createSheet("Bill");
		
		XMLParser p = new XMLParser();
		ArrayList arr = p.getXmlContent(xmlFile);
		XSSFRow  row;
		int a = 0;
		int n = arr.size();
		
		for(int j=0;j<n;j++)
		{
			row = sheet.createRow(a);
			row.createCell(0).setCellValue(arr.get(j).toString());
			a++;
		}
		
		
	
		workbook.write(fileOut);    
		fileOut.close();    
		workbook.close(); 
		System.out.println("File created.....");
	}	
	
	public static XMLtoExcel getObj() {
		if(obj==null)
			return new XMLtoExcel();
		return obj;
	}
}

