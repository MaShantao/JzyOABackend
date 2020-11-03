package com.marico.ncovreportsystem.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	
	 public static Workbook getExcel(String filePath) throws Exception{
	        File file=new File(filePath);
	        Workbook workBook=null;
	        if(!file.exists()){
	        	System.out.println("文件不存在");
	        	throw new Exception("表格文件不存在");
	        }
	        else {
	            String fileType=filePath.substring(filePath.lastIndexOf("."));//获得后缀名
	            try {
	                InputStream is = new FileInputStream(filePath);
	                if(".xls".equals(fileType)){
	                    workBook = new HSSFWorkbook(is);
	                }else if(".xlsx".equals(fileType)){
	                    workBook = new XSSFWorkbook(is);
	                }
	            }catch (Exception e){
	                e.printStackTrace();
	                throw new Exception("表格格式不正确");
	            }
	        }
	        return workBook;
	    }
	 
}
