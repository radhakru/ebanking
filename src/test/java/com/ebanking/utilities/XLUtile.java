package com.ebanking.utilities;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtile {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cells;

	
public static int getRowCount(String xlfile,String xlsheet) throws IOException
{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	int countrow=ws.getLastRowNum();
	wb.close();
	fi.close();
	return countrow;
}
	
public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException	
{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row=ws.getRow(rownum);
	int countcell=row.getLastCellNum();
	wb.close();
	fi.close();
	return countcell;
}
public static String getCellData(String xlfile,String xlsheet,int rownum,int column) throws IOException
{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row=ws.getRow(rownum);
	cells=row.getCell(column);
	
	String data;
	try
	{
		
		DataFormatter formater=new DataFormatter();
		String cell=formater.formatCellValue(cells);
		return cell;
		
	}
	catch(Exception e)
	{
		data="";
	}
	wb.close();
	fi.close();
	return data;
	
}
public static void setCellData(String xlfile,String xlsheet,int rownum,int coloum,String data) throws IOException
{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row=ws.getRow(rownum);
	cells=row.createCell(coloum);
	cells.setCellValue(data);
}
	
}




