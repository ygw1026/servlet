package com.nhnacademy.study;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        try(PrintWriter writer = response.getWriter()){
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
                writer.println("<head>");
                    writer.println("<meta charset='utf-8'>");
                writer.println("</head>");
                writer.println("<body>");
                    writer.println("<h1>hello servlet!</h1>");
                    writer.println("<h1>반갑다 서블릿!</h1>");
                writer.println("</body>");
            writer.println("</html>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    public void destroy() {
    }
}