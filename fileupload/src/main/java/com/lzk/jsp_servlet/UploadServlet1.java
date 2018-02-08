package com.lzk.jsp_servlet;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created by lzk on 2018/2/8 18:13
 * Description:
 */
public class UploadServlet1 extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 得到 FileItem 的集合 items
        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();
//		FileCleaningTracker fileCleaningTracker =
//				FileCleanerCleanup.getFileCleaningTracker(getServletContext());
//		factory.setFileCleaningTracker(fileCleaningTracker);

        // Set factory constraints
        factory.setSizeThreshold(1024 * 500);
        File tempDirectory = new File("D:\\Workspaces\\test\\idea\\fileupload\\tempDirectory");

        factory.setRepository(tempDirectory);

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");//解决中文名乱码问题
        // Set overall request size constraint
        upload.setSizeMax(1024 * 1024 * 5);
        // Parse the request
        try {
            @SuppressWarnings("unchecked")
            List<FileItem> /* FileItem */items = upload.parseRequest(request);
            // 2. 遍历 items:
            for (FileItem item : items) {
                // 若是一个一般的表单域, 打印信息
                if (item.isFormField()) {
                    String name = item.getFieldName();
                    String value = item.getString();
                    System.out.println(name + ": " + value);
                }
                // 若是文件域则把文件保存到 d:\\files 目录下.
                else {
                    String fieldName = item.getFieldName();
                    String fileName = item.getName();
                    String contentType = item.getContentType();
                    long sizeInBytes = item.getSize();

                    System.out.println(fieldName);
                    System.out.println(fileName);
                    System.out.println(contentType);
                    System.out.println(sizeInBytes);

                    InputStream in = item.getInputStream();
                    byte[] buffer = new byte[1024];
                    int len = 0;

                    String path = getServletContext().getRealPath("/resources/images");
                    File dir = new File(path);
                    if (!dir.exists()){
                        dir.mkdir();
                    }
                    fileName = path + "\\" +fileName;
                    System.out.println(fileName);

                    OutputStream out = new FileOutputStream(fileName);

                    while ((len = in.read(buffer)) != -1) {
                        out.write(buffer, 0, len);
                    }
                    out.close();
                    in.close();
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}
