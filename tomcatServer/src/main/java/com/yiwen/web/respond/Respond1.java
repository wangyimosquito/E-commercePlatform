package com.yiwen.web.respond;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/resp1")
public class Respond1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        System.out.println("resp1...");

        //redirect to intro-resources
        String contextPath = req.getContextPath();
        System.out.println("context path = "+contextPath);
        //resp.setStatus(302);
        //resp.setHeader("location", "/resp2");

        //redirect to outer-resources
        resp.sendRedirect(contextPath+"/resp2");
    }
}
