package com.nhnacademy.study.filter;

import com.nhnacademy.study.CounterUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class CounterFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        log.debug("CounterFilter invoked. URI: {}", req.getRequestURI());

        CounterUtils.increaseCounter(servletRequest.getServletContext());
        log.debug("counter:{}", servletRequest.getServletContext().getAttribute("counter"));

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
