package com.lzk.jsp_servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * Created by lzk on 2018/2/8 20:15
 * Description:
 */
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = getServletContext().getRealPath("/") + "resources\\images";
        System.out.println(path);
        String filename = request.getParameter("filename");
        System.out.println(filename);
        path = path + "\\" + filename;
        System.out.println(path);
        File file = new File(path);
        if (file.exists()) {
            response.setContentType("application/force-download");//应用程序强制下载
            filename = URLEncoder.encode(filename, "UTF-8");//编码
            response.setHeader("Content-Disposition", "attachment;filename="+filename);
            FileInputStream in = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int len = 0;
            OutputStream out = response.getOutputStream();
            while((len = in.read(bytes))!=-1){
                out.write(bytes,0,len);
            }
            out.close();
            in.close();
        } else {
            request.setAttribute("result","文件不存在或下载失败！");
            request.getRequestDispatcher("result.jsp").forward(request,response);
        }
    }
}
