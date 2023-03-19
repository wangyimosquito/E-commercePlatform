package com.yiwen.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

@WebServlet(urlPatterns = {"/demo4"})
public class ServletDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //get request method (GET, POST, ...)
        String method = req.getMethod();
        System.out.println("method: " + method);

        //get context Path (default module name)
        String contextPath = req.getContextPath();
        System.out.println("contextPath: " + contextPath);

        //get url
        StringBuffer url = req.getRequestURL();
        System.out.println("url: " + url.toString());

        //get uri
        String uri = req.getRequestURI();
        System.out.println("uri: " + uri);


        //get query string
        String queryString = req.getQueryString();
        System.out.println("queryString: " + queryString);

        //get header
        String header = req.getHeader("user-agent");
        System.out.println("header: "+header);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get
        BufferedReader br = req.getReader();

        String line = br.readLine();
        System.out.println("post request body: "+line);
    }
}