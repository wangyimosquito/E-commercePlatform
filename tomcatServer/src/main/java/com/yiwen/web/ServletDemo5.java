package com.yiwen.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = {"/demo5"})
public class ServletDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Map<String, String[]> map = req.getParameterMap();
        for (String s : map.keySet()) {
            System.out.print(s+":");
            String[] values = map.get(s);
            for (String value : values) {
                System.out.print(value+" ");
            }
            System.out.println(" ");
        }


        System.out.println("----------------------------");
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }

        String usrname = req.getParameter("username");
        String pwd = req.getParameter("password");
        System.out.println("username: "+usrname);
        System.out.println("password:"+pwd);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}