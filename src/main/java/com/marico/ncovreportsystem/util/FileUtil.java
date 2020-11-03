package com.marico.ncovreportsystem.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileUtil {
		
	 /**
     * 下载文件到浏览器
     * @param request
     * @param response
     * @param filename 要下载的文件名
     * @param file     需要下载的文件对象
     * @throws IOException
     */
    public static void downFile(HttpServletRequest request, HttpServletResponse response, String filename) throws IOException {
    	File file = new File(filename);
    	//  文件存在才下载
        if (file.exists()) {
            OutputStream out = null;
            FileInputStream in = null;
            // 1.读取要下载的内容
            in = new FileInputStream(file);

            // 2. 告诉浏览器下载的方式以及一些设置
            // 解决文件名乱码问题，获取浏览器类型，转换对应文件名编码格式，IE要求文件名必须是utf-8, firefo要求是iso-8859-1编码
            boolean isMSIE = HttpUtils.isMSBrowser(request);
            if (isMSIE) {
            //IE浏览器的乱码问题解决
            	filename = URLEncoder.encode(filename, "UTF-8");
            } else {
                //万能乱码问题解决
            	filename = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
            }
            // 设置下载文件的mineType，告诉浏览器下载文件类型
            
            //String mineType = request.getServletContext().getMimeType(filename);
            String mineType = Files.probeContentType(Paths.get(filename));
            response.setContentType(mineType);
            // 设置一个响应头，无论是否被浏览器解析，都下载
            response.setHeader("Access-Control-Expose-Headers", "Content-Disposition"); 
            response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE"); 
            response.setHeader("Access-Control-Max-Age", "3600"); //设置过期时间 
            response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, client_id, uuid, Authorization"); 
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 支持HTTP 1.1. 
            response.setHeader("Pragma", "no-cache"); // 支持HTTP 1.0. response.setHeader("Expires", "0"); 
            response.setHeader("Content-disposition", "attachment; filename=" + filename);
            response.setHeader("filename", filename);
            // 将要下载的文件内容通过输出流写到浏览器
            out = response.getOutputStream();
            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
        }
    }

    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     *
     * @param filePath 将要删除的文件目录路径
     * @return boolean Returns "true" if all deletions were successful.
     * If a deletion fails, the method stops attempting to
     * delete and returns "false".
     */
    public static boolean deleteDir(String filePath) {
        File dir = new File(filePath);
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(filePath + File.separator + children[i]);
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
		
	}
    
    
    /**
     * 打包成zip包
     */
    public static void generateZip(List<String> fileNameList,String zipFileName) throws Exception {
        ZipOutputStream out = null;
        try {
            byte[] buffer = new byte[1024];
            //生成的ZIP文件名为Demo.zip
            out = new ZipOutputStream(new FileOutputStream(new File(zipFileName)));
            //需要同时下载的两个文件result.txt ，source.txt
            for (String fileName : fileNameList) {
                FileInputStream fis = new FileInputStream(new File(fileName));
                out.putNextEntry(new ZipEntry(fileName));
                int len;
                //读入需要下载的文件的内容，打包到zip文件
                while ((len = fis.read(buffer)) != -1) {
                    out.write(buffer, 0, len);
                }
                out.flush();
                out.closeEntry();
                fis.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

}
