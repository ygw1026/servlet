package com.nhnacademy.study;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class MultipleServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] values = req.getParameterValues("class");
        String url = getServletContext().getInitParameter("url");
        try(PrintWriter out = resp.getWriter()){
            out.println(String.join(",", values));
            out.printf("url:%s\n", url);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
