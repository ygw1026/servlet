package com.nhnacademy.study.file;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class FileDownloadServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "/home/nhnacademy/IdeaProjects/study/src/main/upload";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

    }
}
