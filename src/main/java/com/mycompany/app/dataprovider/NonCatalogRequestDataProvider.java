package com.mycompany.app.dataprovider;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mycompany.app.objects.NonCatalogRequestObject;


public class NonCatalogRequestDataProvider {

//	private static final int COLUMNCOUNT = 1;
	public static NonCatalogRequestObject getNCRObject()
	{
		return getData();
	}


	private static NonCatalogRequestObject getData()
	{
		int i = 0; //j = 0;
		NonCatalogRequestObject nonCatalogRequestObject = new NonCatalogRequestObject();
		try {
			// src = new File("C:\\Users\\aseem\\eclipse-workspace\\GapTestAutomation\\src\\resources\\TestData.xlsx");

			InputStream fIS = new FileInputStream("./src/main/java/com/mycompany/app/dataprovider/TestData.xlsx");
			XSSFWorkbook workbook1 = new XSSFWorkbook(fIS);

			XSSFSheet sheet = workbook1.getSheetAt(0);

     				nonCatalogRequestObject.setItemType(Integer.parseInt(sheet.getRow(i).getCell(0).getRawValue()));
     				nonCatalogRequestObject.setItemDescription(sheet.getRow(i).getCell(1).getStringCellValue());
     				nonCatalogRequestObject.setCategory(sheet.getRow(i).getCell(2).getStringCellValue());
     				nonCatalogRequestObject.setQuantity(Integer.parseInt(sheet.getRow(i).getCell(3).getRawValue()));
     				nonCatalogRequestObject.setUnitOfMeasure(sheet.getRow(i).getCell(4).getStringCellValue());
     				nonCatalogRequestObject.setUnitPrice(Integer.parseInt(sheet.getRow(i).getCell(5).getRawValue()));
     				nonCatalogRequestObject.setCurrency(Integer.parseInt(sheet.getRow(i).getCell(6).getRawValue()));
     				nonCatalogRequestObject.setItemDescription(sheet.getRow(i).getCell(7).getStringCellValue());
     				nonCatalogRequestObject.setRfqRequired(Boolean.parseBoolean(sheet.getRow(i).getCell(8).getRawValue()));
     				nonCatalogRequestObject.setNegotiated(Boolean.parseBoolean(sheet.getRow(i).getCell(9).getRawValue()));
     				nonCatalogRequestObject.setContractNumber(Integer.parseInt(sheet.getRow(i).getCell(10).getRawValue()));
     				nonCatalogRequestObject.setSupplierItem(sheet.getRow(i).getCell(15).getStringCellValue());
     				nonCatalogRequestObject.setSite(sheet.getRow(i).getCell(12).getStringCellValue());
     				nonCatalogRequestObject.setContactName(sheet.getRow(i).getCell(13).getStringCellValue());
     				nonCatalogRequestObject.setPhoneNumber(sheet.getRow(i).getCell(14).getStringCellValue());
     				nonCatalogRequestObject.setSupplierName(sheet.getRow(i).getCell(13).getStringCellValue());



     		nonCatalogRequestObject.print();

					workbook1.close();
     			fIS.close();


		}catch(Exception e)

		{
			System.out.println(e.getMessage());

		}finally {

		}


		return nonCatalogRequestObject;
	}

	public static void main(String[] str)
	{
		NonCatalogRequestObject ncro = getData();
		ncro.print();
	}
}
