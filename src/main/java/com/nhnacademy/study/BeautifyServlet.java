package com.nhnacademy.study;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;
import org.jsoup.Jsoup;

@Slf4j
public class BeautifyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        String html = req.getParameter("html");
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");

        try(PrintWriter out = resp.getWriter()){
            out.println(Jsoup.parse(html));
        }catch (Exception ex) {
            log.info(ex.getMessage());
        }
    }
}
