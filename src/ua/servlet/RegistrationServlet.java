package ua.servlet;

import ua.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static ua.servlet.LoginServlet.usersMap;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentLogin1 = request.getParameter("login");
        String currentPass1 = request.getParameter("password");

        User user = new User(currentLogin1, currentPass1, false);
        usersMap.put(currentLogin1, user);

        HttpSession session = request.getSession(true);

        session.setAttribute("user_login", usersMap.get(currentLogin1).getPass());

        request.getRequestDispatcher("/forumPage.jsp").forward(request,response);
    }

}
