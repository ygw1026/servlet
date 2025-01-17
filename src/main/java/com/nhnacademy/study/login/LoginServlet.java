package com.nhnacademy.study.login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@Slf4j
public class LoginServlet extends HttpServlet {

    private String initParamId;
    private String initParamPwd;

    @Override
    public void init(ServletConfig config) throws ServletException {
        initParamId = config.getInitParameter("id");
        initParamPwd = config.getInitParameter("pwd");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        HttpSession session = req.getSession(false);
        if(Objects.isNull(session)){
            resp.sendRedirect("/login.html");
        }else{
            resp.setContentType("text/html");
            resp.setCharacterEncoding("utf-8");

            try(PrintWriter out = resp.getWriter()){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                    out.println("<head>");
                        out.println("<meta charset='utf-8'>");
                    out.println("</head>");
                    out.println("<body>");
                        out.println("login success : id =" + session.getAttribute("id") + "<br/>");
                        out.println("<a href='/logout'>logout</a>");
                    out.println("</body>");
                out.println("</html>");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");

        if(initParamId.equals(id) && initParamPwd.equals(pwd)){
            HttpSession session = req.getSession();
            session.setAttribute("id", id);
            log.debug("Login succesful. Redirecting to /login");
            resp.sendRedirect("/login");
        }else{
            log.error("아이디/패스워드가 일치하지 않습니다.");
            // Redirect : 클라이언트에게 HTTP 302 코드와 함께 새로운 URL 을 전달하여, 브라우저가 다시 요청을 전송하도록 지시하는 방식
            // 동작과정
            // 1. 클라이언트가 서버에 A 요청을 보냄
            // 2. 서버가 302 응답을 반환하며 /login.html 로 리다이렉트 지시
            // 3. 브라우저가 /login.html로 새로운 요청 보냄
            // 특징 : 클라이언트와 서버 간의 새로운 요청이 발생함. 브라우저의 주소창이 변경됨. 이전 요청의 request객체 데이터는 유지되지 않음. 주로 외부URL로 전환하거나, 요청처리를 종료하고 새로운 작업을 시작할 때 사용함.
//            resp.sendRedirect("/login.html");

            // RequestDispatcher : 포워드는 서버 내부에서 요청을 다른 리소스(Servlet, JSP 등) 로 전달하는 방식
            // 동작과정
            // 1. 클라이언트가 서버에 A요청 보냄
            // 2. 서버 내부에서 A dycjddmf /login.html로 전달
            // 3. 클라이언트는 여전히 A요청에 대한 응답을 받음
            // 특징 : 서버내부에서 요청을 처리하므로 클라이언트는 이를 인지하지 못함. 브라우저의 주소창이 변경되지 않음. 기존 요청 객체(request, session 객체 등) 유지한채로 데이터 전달 가능. 주로 오류 페이지로 이동하거나, 요청처리를 이어서 다른 리소스에서 수행할 때 사용함.
            RequestDispatcher rd = req.getRequestDispatcher("/login.html");
            rd.forward(req,resp);
        }
    }
}
