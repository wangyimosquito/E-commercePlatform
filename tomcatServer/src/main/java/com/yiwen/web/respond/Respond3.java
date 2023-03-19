package com.yiwen.web.respond;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/resp3")
public class Respond3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);
        PrintWriter writer = resp.getWriter();
        //set content type
        resp.setHeader("content-type", "text/html");
        writer.write("aaa");
        writer.write("<h1>aaaa</h1>");
        //no need to close the PrintWriter
    }
}
