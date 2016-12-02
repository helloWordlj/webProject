package com.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadTest extends HttpServlet{

	private static final long serialVersionUID = 1L;  
    private String uploadPath = "D:\\temp"; // 上传文件的目录  
    File tempPathFile;  
  
    // 重写doPost方法，处理事件识别请求  
    protected void doPost(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException, IOException {  
        try {  
        	System.out.println("upload5");
            // Create a factory for disk-based file items  
            DiskFileItemFactory factory = new DiskFileItemFactory();  
  
            // Set factory constraints  
            factory.setSizeThreshold(4096); // 设置缓冲区大小，这里是4kb  
            factory.setRepository(tempPathFile);// 设置缓冲区目录  
  
            // Create a new file upload handler  
            ServletFileUpload upload = new ServletFileUpload(factory);  
  
            // Set overall request size constraint  
            upload.setSizeMax(1024 * 1024 * 1024); // 设置最大文件尺寸，这里是1G  
  
            List<FileItem> items = upload.parseRequest(request);// 得到所有的文件  
            Iterator<FileItem> i = items.iterator();  
            while (i.hasNext()) {  
                FileItem fi = (FileItem) i.next();  
                String fileName = fi.getName();  
                if (fileName != null) {  
                    File fullFile = new File(new String(fi.getName().getBytes(), "utf-8")); // 解决文件名乱码问题  
                    File savedFile = new File(uploadPath, fullFile.getName());  
                    fi.write(savedFile);  
                }  
            }  
            response.getWriter().write("succeed");
            System.out.print("upload succeed");  
        } catch (Exception e) {  
        	System.out.println(e.getMessage());
        }  
    }  
    
    public void doGet(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException, IOException { 
    	doPost(request, response);
    }
}
