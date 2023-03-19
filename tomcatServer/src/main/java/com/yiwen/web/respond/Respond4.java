package com.yiwen.web.respond;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/resp4")
public class Respond4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get file
        FileInputStream fis =  new FileInputStream("D:\\2023春季学期\\Java Intro & Practice\\e-costomerservice\\tomcatServer\\src\\main\\java\\com\\yiwen\\web\\respond\\closer.jpg");
        //get outputstream
        ServletOutputStream os =  resp.getOutputStream();
        //complete stream copy
//        byte[] buff = new byte[1024];
//        int len = 0;
//        while((len = fis.read(buff))!=-1){
//            os.write(buff, 0, len);
//        }
        //use a simpler way of doing this
        IOUtils.copy(fis, os);

        fis.close();
    }
}
