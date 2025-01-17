package com.nhnacademy.study;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@Slf4j
public class RequestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.resetBuffer();

        log.info("default buffer size : {}", resp.getBufferSize());
        resp.setBufferSize(1024);

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        try(PrintWriter out = resp.getWriter()){
            out.println("locale=" + req.getLocale());
            out.println("parameter name=" + req.getParameter("userId"));
//            out.flush();
//            out.close();

            String userId = req.getParameter("userId");
            log.info("userId:{}", userId);
            if(userId == null || userId.isEmpty()){
                resp.reset();
                resp.setStatus(500);
                resp.sendError(500, "name is empty");
                return;
            }

            String redirect = req.getParameter("redirect");
            if(Objects.nonNull(redirect)){
                resp.sendRedirect(redirect);
                return;
            }

            out.println("method=" + req.getMethod());
            out.println("request uri=" + req.getRequestURI());


            out.println("User-Agent header=" + req.getHeader("User-Agent"));
            out.flush();
        }catch (Exception e){
            log.error("/req : {}", e.getMessage(),e);
        }
    }
}
