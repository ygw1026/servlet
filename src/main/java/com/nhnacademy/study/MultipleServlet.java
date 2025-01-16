package com.nhnacademy.study;

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

        try(PrintWriter out = resp.getWriter()){
            out.println(String.join(",", values));
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
