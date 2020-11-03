package com.marico.ncovreportsystem.util;

import java.io.ByteArrayOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.marico.ncovreportsystem.pojo.TbDictionary;
import com.marico.ncovreportsystem.service.DictionaryService;

@Component
public class PDFUtil implements ApplicationContextAware{
	
	private static Map<Integer, String> pdfTemplatePathMap = null;

	private static ApplicationContext applicationContext;
	 
	private static BaseFont baseFont = null;
	
	// 利用模板生成pdf
	public static void pdfout(Map<String, Object> data, String templatePath, String newPDFPath) {
		PdfReader reader;
		FileOutputStream out;
		ByteArrayOutputStream bos;
		PdfStamper stamper;
		try {
			String fontStr = new Object() {}.getClass().getClassLoader().getResource("songti.ttf").getPath();
			BaseFont bf = BaseFont.createFont(fontStr, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font FontChinese = new Font(bf, 5, Font.NORMAL);
			File newFile = new File(newPDFPath);
			newFile.createNewFile();
			out = new FileOutputStream(newFile);// 输出流
			reader = new PdfReader(templatePath);// 读取pdf模板

			bos = new ByteArrayOutputStream();
			stamper = new PdfStamper(reader, bos);
			AcroFields form = stamper.getAcroFields();
			// 文字类的内容处理
			Map<String, String> textmap = (Map<String, String>) data.get("textmap");
			form.addSubstitutionFont(bf);
			for (String key : textmap.keySet()) {
				String value = textmap.get(key);
				form.setField(key, value);
			}
			// 图片类的内容处理
			Map<String, String> imgmap = (Map<String, String>) data.get("imgmap");
			for (String key : imgmap.keySet()) {
				String value = imgmap.get(key);
				String imgpath = value;
				// 根据路径读取图片
				Image image = Image.getInstance(imgpath);
				for (int i = 0; i < form.getFieldPositions(key).size(); i++) {
					int pageNo = form.getFieldPositions(key).get(i).page;
					Rectangle signRect = form.getFieldPositions(key).get(i).position;
					float x = signRect.getLeft();
					float y = signRect.getBottom();
					// 获取图片页面
					PdfContentByte under = stamper.getOverContent(pageNo);
					// 图片大小自适应
					image.scaleToFit(signRect.getWidth(), signRect.getHeight());
					// 添加图片
					image.setAbsolutePosition(x, y);
					under.addImage(image);
				}

			}
			stamper.setFormFlattening(true);// 如果为false，生成的PDF文件可以编辑，如果为true，生成的PDF文件不可以编辑
			stamper.close();
			Document doc = new Document();
			Font font = new Font(bf, 32);
			PdfCopy copy = new PdfCopy(doc, out);
			doc.open();
			for (int i = 1; i <= reader.getNumberOfPages(); i++) {
				PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), i);
				copy.addPage(importPage);
			}
			doc.close();
		} catch (IOException e) {
			System.out.println(e);
		} catch (DocumentException e) {
			System.out.println(e);
		}
	}
	
	public static  boolean generateReport(Map<String, Object> data, Integer templateType, String newPDFPath) {
		FileOutputStream out;
		ByteArrayOutputStream bos;
		PdfStamper stamper;
		try {
			File newFile = new File(newPDFPath);
			newFile.createNewFile();
			out = new FileOutputStream(newFile);// 输出流
			PdfReader reader = new PdfReader(pdfTemplatePathMap.get(templateType));// 读取pdf模板
			bos = new ByteArrayOutputStream();
			stamper = new PdfStamper(reader, bos);
			AcroFields form = stamper.getAcroFields();
			// 文字类的内容处理
			Map<String, String> textmap = (Map<String, String>) data.get("textmap");
			form.addSubstitutionFont(baseFont);
			for (String key : textmap.keySet()) {
				String value = textmap.get(key);
				form.setField(key, value);
			}
			// 图片类的内容处理
			Map<String, String> imgmap = (Map<String, String>) data.get("imgmap");
			for (String key : imgmap.keySet()) {
				String value = imgmap.get(key);
				String imgpath = value;
				// 根据路径读取图片
				Image image = Image.getInstance(imgpath);
				for (int i = 0; i < form.getFieldPositions(key).size(); i++) {
					int pageNo = form.getFieldPositions(key).get(i).page;
					Rectangle signRect = form.getFieldPositions(key).get(i).position;
					float x = signRect.getLeft();
					float y = signRect.getBottom();
					// 获取图片页面
					PdfContentByte under = stamper.getOverContent(pageNo);
					// 图片大小自适应
					image.scaleToFit(signRect.getWidth(), signRect.getHeight());
					// 添加图片
					image.setAbsolutePosition(x, y);
					under.addImage(image);
				}
			}
			stamper.setFormFlattening(true);// 如果为false，生成的PDF文件可以编辑，如果为true，生成的PDF文件不可以编辑
			stamper.close();
			Document doc = new Document();
			PdfCopy copy = new PdfCopy(doc, out);
			doc.open();
			for (int i = 1; i <= reader.getNumberOfPages(); i++) {
				PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), i);
				copy.addPage(importPage);
			}
			doc.close();
		} catch (IOException e) {
			System.out.println(e);
			return false;
		} catch (DocumentException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap();
		map.put("code", "张三");
		map.put("hospital", "2018年1月1日");

		Map<String, String> map2 = new HashMap();
		map2.put("img", "G:\\data\\1.png");

		Map<String, Object> data = new HashMap();
		data.put("textmap", map);
		data.put("imgmap", map2);
		PDFUtil pdfUtils = new PDFUtil();
		pdfout(data, "G://test.pdf", "G://test2.pdf");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		if (PDFUtil.applicationContext == null) {
			PDFUtil.applicationContext = applicationContext;
			try {
				pdfTemplatePathMap = new HashMap<Integer, String>();
				baseFont = BaseFont.createFont(new Object() {
				}.getClass().getClassLoader().getResource("songti.ttf").getPath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
				// 查询所有的testType对应的pdf模板地址
				String basePath = System.getProperty("user.dir") + "\\";
				DictionaryService dictionaryService = applicationContext.getBean(DictionaryService.class);
				List<TbDictionary> testTypeList = dictionaryService.listByDictName("test_types");
				for (TbDictionary dictionary : testTypeList) {
					pdfTemplatePathMap.put(dictionary.getDictId(), basePath + dictionary.getDictMark() + "_template.pdf");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
        }
	}
}