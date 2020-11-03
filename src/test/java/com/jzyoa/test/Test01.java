package com.jzyoa.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.github.pagehelper.Page;
import com.jzyoa.pojo.TbReport;

public class Test01 {

	
	
	@Test
	public void test1() {
		Page<TbReport> pages = (Page<TbReport>)null;
		List list  = pages;
		System.out.println(pages);
		System.out.println(list);
	}
	
	@Test
	public void Test2() {
	}
	public static void main(String[] args) {
		Scanner  scanner= new Scanner(System.in);
		double sum = 0;
		while(scanner.hasNext()) {
			String text = scanner.nextLine();
			if("0".equals(text)) break;
			int indexb = text.indexOf("// b");
			int indexe = text.indexOf("// e");
			if(indexb!=-1) {sum+= Double.parseDouble(text.substring(indexb+4));}
			if(indexe!=-1) {sum+= Double.parseDouble(text.substring(indexe+4));}
			int indexNum = text.split("// \\d")[0].length();
			if(indexNum!=text.length()) {
				sum+= Double.parseDouble(text.substring(indexNum+2));
			}
		}
		System.out.println(sum);
		scanner.close();	
	}
	
	@Test
	public void Test03() {
		try {
			String mineType = Files.probeContentType(Paths.get("C:\\Users\\Oxygen\\Downloads\\测试下载zip文件 (2).zip"));
			System.out.println(mineType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
