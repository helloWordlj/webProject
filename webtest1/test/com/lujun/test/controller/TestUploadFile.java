package com.lujun.test.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lujun.test.Util;

@Controller
@RequestMapping("/test/upload")
public class TestUploadFile {
	
	private Logger logger=Logger.getLogger(TestUploadFile.class);
	
	String dir = null;
	String tempDir = "D:\\temp";
    
    /**
     * 获取上传文件路径的bean对象。
     */
    public TestUploadFile() {
        try {
            Properties prop = PropertiesLoaderUtils.loadProperties(new ClassPathResource("/task.properties"));
            dir = prop.getProperty("etl.dir.undo");
        } 
        catch (IOException e) {
            logger.error("get uplaodFile path bean object error!", e);
        }
    }

	/**
     * 文件上传。
     * @param files 文件
     * @param request 请求
     * @exception Exception 异常
     * @return int
     */
    @RequestMapping("/upload2")
    public void uploadFile(@RequestParam MultipartFile[] files ,
            HttpServletRequest request) throws Exception {
    	System.out.println("upload2");
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                if (!new File(dir).exists()) {
                    new File(dir).mkdir();
                }
                FileUtils.copyInputStreamToFile(file.getInputStream(), new File(dir, file.getOriginalFilename()));
            }
        }
    }
    
    @RequestMapping("/upload3")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("进来了");
		String files=request.getParameter("files");
		System.out.println(files);
		try {
			// 上传文件的临时目录
			//String temp = request.getParameter("folder");
			//System.out.println(temp);
			
					//request.getSession().getServletContext().getRealPath("uploads");
			File tFile = new File(tempDir);
			if (!tFile.exists())
				tFile.mkdir();
			// 创建缓冲区
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 设置缓冲区大小 1*1024*1024 设置1Mb
			factory.setSizeThreshold(1 * 1024 * 1024);
			// 设置缓冲临时目录
			factory.setRepository(new File(tempDir));
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 设置编码
			upload.setHeaderEncoding("UTF-8");
			//response.setContentType("text/plain;charset=utf-8");
			// 设置文件最大值,这里设置5Mb,5*1024*1024;
			upload.setSizeMax(5 * 1024 * 1024);
			FileItemIterator fileItem = upload.getItemIterator(request); // 得到所有的文件
			System.out.println("fileItem:"+fileItem);
			while (fileItem.hasNext()) {// 根本没进来
				FileItemStream fi = fileItem.next(); // 获得文件流
				if (!fi.isFormField() && fi.getName().length() > 0) { // 过滤非文件域

					String fileName = fi.getName(); // 获取文件名称
					String fName = tempDir + "\\" + fileName; // 文件最终存放目录
					File file = new File(fName);
					FileOutputStream out = new FileOutputStream(file);
					out.write(fi.toString().getBytes());
					out.flush();
					out.close();
				}
			}
			Random r = new Random(10);
			response.getWriter().write("" + r.nextInt());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
    
    @RequestMapping("upload4")
	public String upload4(HttpServletRequest request,
			HttpServletResponse response,File files) {
    	System.out.println("aaaaaaaa");
		try {
			// 文件上传，存至硬盘
			String realfilePath = request.getSession().getServletContext()
					.getRealPath("uploads");
			File targetFile = new File(realfilePath);
			Util.upLoadFile(files, targetFile);
		} catch (Exception ex) {
			ex.printStackTrace();
			return "ERROR";
		}
		return "SUCCESS";
	}
    
    @RequestMapping("/upload5")
    public void upload5(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException, IOException {  
        try {  
        	System.out.println("spring_mvc_upload5");
            // Create a factory for disk-based file items  
            DiskFileItemFactory factory = new DiskFileItemFactory();  
  
            // Set factory constraints  
            factory.setSizeThreshold(4096); // 设置缓冲区大小，这里是4kb  
            factory.setRepository(new File(tempDir));// 设置缓冲区目录  
  
            // Create a new file upload handler  
            ServletFileUpload upload = new ServletFileUpload(factory);  
  
            // Set overall request size constraint  
            upload.setSizeMax(4194304); // 设置最大文件尺寸，这里是4MB  
  
            List<FileItem> items = upload.parseRequest(request);// 得到所有的文件  
            Iterator<FileItem> i = items.iterator();  
            while (i.hasNext()) {  
                FileItem fi = (FileItem) i.next();  
                String fileName = fi.getName();  
                if (fileName != null) {  
                    File fullFile = new File(new String(fi.getName().getBytes(), "utf-8")); // 解决文件名乱码问题  
                    File savedFile = new File(tempDir, fullFile.getName());  
                    fi.write(savedFile);  
                }  
            }  
            response.getWriter().write("succeed");
            System.out.print("upload succeed");  
        } catch (Exception e) {  
        	System.out.println(e.getMessage());
        }  
    }  

}
