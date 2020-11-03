package com.marico.ncovreportsystem.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.data.PictureRenderData;
import com.deepoove.poi.policy.PictureRenderPolicy;

public class Test {

	public static void downWord(Map<String, Object> data, String TemplatePath, List<String>pictureTag,String wordName) throws Exception {
		 try {
			   ClassPathResource template = new ClassPathResource(TemplatePath);
	            String projectPath = System.getProperty("user.dir");    //获取当前项目所在路径
	            //创建一个临时模板，放在系统上（这步很无奈）
	            File file = new File(projectPath+"/template.docx");
	            InputStream templateInputStream = template.getInputStream();
	            FileUtils.copyInputStreamToFile(templateInputStream,file);
	            XWPFTemplate xwpfTemplate = XWPFTemplate.compile(file);
	            Configure config = xwpfTemplate.getConfig();
	            //设置处理策略，这一步很重要，本人在这个坑上跌了很久！！！
	            for (String tag:pictureTag
	                 ) {
	                config.customPolicy(tag,new PictureRenderPolicy());
	            }
	            //将数据递交给模板处理
	            xwpfTemplate.render(data);
	            String docName = wordName + ".docx";
	            File targetFile = new File(docName);
	            FileOutputStream out = new FileOutputStream(targetFile);
	            xwpfTemplate.write(out);
	            out.flush();
	            out.close();
	            xwpfTemplate.close();
	        } catch (Exception e) {
	           throw e;
	        }
		
	}
	public static void main(String[] args) throws Exception {

		  List<String> pictureTag =new ArrayList<>();
          Map<String,Object>data =new HashMap<>();
          //需要填充的数据，key为模板中的变量
          data.put("specimen_code","awdawdadawdawdawdwad");
          data.put("hos_name","人民医院");
          data.put("patient_name","张三");
          data.put("dept_name","信息科");
          data.put("specimen_type","111");
          data.put("specimen_code","22");
          //这里是前台传给我的查询图片的id
          String[] files = {"G:\\data\\1.png","G:\\data\\2.png"};
          String [] img= {"reviewer","reporter"};
          int num =files.length;
          String templatePath="ncov.docx";
          //因为图片数量不确定，设计了多种模板处理
          for (int i=0;i<num;i++){
              //这里我是从数据库获取图片路径
              String photoPath = files[i];
//            获取的长宽数值较大，避免插入图片过大，我等比例缩小了10倍
              int width = 80;
              int height =45;
              PictureRenderData pictureRenderData = new PictureRenderData(width, height,photoPath);
              data.put(img[i],pictureRenderData);
              //标识出其中的图片变量，需要特殊处理
              pictureTag.add(img[i]);
          }

          downWord(data,templatePath,pictureTag,"patrol");
	}
}
