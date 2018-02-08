package com.lzk.jsp_servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by lzk on 2018/2/8 16:31
 * Description:
 */
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从request中获取输入流信息
        InputStream fileSource = request.getInputStream();
        //创建存储在服务器的路径信息
        String tempFileName = "D:\\Workspaces\\test\\idea\\fileupload\\aa";
        //指向临时文件
        File tempFile = new File(tempFileName);
        //outPutStream输出流指向临时文件
        FileOutputStream outputStream = new FileOutputStream(tempFile);
        //每次读取文件字节
        byte b[] = new byte[1024];
        int n;
        while((n=fileSource.read(b))!=-1){
            outputStream.write(b,0,n);
        }

        //关闭输出输入流
        fileSource.close();
        outputStream.close();

        //获取上传文件的名称
        RandomAccessFile randomFile = new RandomAccessFile(tempFile, "r");
        randomFile.readLine();  //获取第一行数据（对我们来说没有意义）
        String str = randomFile.readLine();  //获取第二行数据，内容为：Content-Disposition: form-data; name="myfile"; filename="C:\Users\lihf\Desktop\hello.txt"
        /*int endIndex = s.lastIndexOf("\"");
        s = s.substring(0,endIndex);
        int startIndex = s.lastIndexOf("\"")+1;
        s = s.substring(startIndex);
        System.out.println(s);*/
        int endIndex = str.lastIndexOf("\"");
        str = str.substring(0,endIndex);
        int beginIndex = str.lastIndexOf("\"")+1;
        String fileName = str.substring(beginIndex);
        System.out.println("fileName: " +fileName);
        //重新定位文件指针到头文件
        randomFile.seek(0);
        long startPosition=0;
        int i=1;
        //获取文件内容开始位置
        while((n=randomFile.readByte())!=-1&&i<=4){
            if(n=='\n'){
                startPosition = randomFile.getFilePointer();
                i++;
            }
        }
        startPosition = randomFile.getFilePointer() -1;
        //获取文件结束位置
        randomFile.seek(randomFile.length());  //文件指针定位到文件末尾
        long endPosition = randomFile.getFilePointer();
        int j=1;
        while(endPosition>=0&&j<=2){
            endPosition--;
            randomFile.seek(endPosition);
            if(randomFile.readByte()=='\n'){
                j++;
            }
        }
        endPosition = endPosition -1;

        //设置保存文件上传的路径
        String realPath = getServletContext().getRealPath("/resources/images");
        System.out.println("保存文件上传的路径："+realPath);
        File fileupload = new File(realPath);
        if(!fileupload.exists()){
            fileupload.mkdir();  //创建此抽象路径名指定的目录。
        }
        File saveFile = new File(realPath, fileName);
        RandomAccessFile randomAccessFile = new RandomAccessFile(saveFile,"rw");
        //从临时文件中读取文件内容（根据文件起止位置获取）
        randomFile.seek(startPosition);
        while(startPosition<endPosition){
            randomAccessFile.write(randomFile.readByte());
            startPosition = randomFile.getFilePointer();
        }

        //关闭输入输出流
        randomAccessFile.close();
        randomFile.close();
        //tempFile.delete();
        request.setAttribute("result", "上传成功！");
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }
}
