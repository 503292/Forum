package ua.servlet;

import ua.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    List<User> users = new ArrayList<>();
    public String status = "ok";


    public static final Map<String, User> usersMap = new HashMap<>();

    static {
       User admin = new User("ad", "ad", true);
        usersMap.put("ad", admin);

    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String currentLogin = request.getParameter("login");
        String currentPass = request.getParameter("password");
        HttpSession session = request.getSession(true);
        status = "ok";


        if (usersMap.containsKey(currentLogin)) {
            if (currentPass.equals(usersMap.get(currentLogin).getPass())) {



                session.setAttribute("user_login", usersMap.get(currentLogin).getPass());
                session.setAttribute("status", status);

                request.getRequestDispatcher("/forumPage.jsp").forward(request, response);
            } else {

                status = "Wrong pass";
                session.setAttribute("status", status);
                response.sendRedirect("index.jsp");
            }
        }else{
            status = "Wrong login";
            session.setAttribute("status", status);
            response.sendRedirect("index.jsp");
        }
    }


}