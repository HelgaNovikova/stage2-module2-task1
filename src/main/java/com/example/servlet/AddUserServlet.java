package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
    //write your code here!

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        User newUser = new User(firstName, lastName);
        Warehouse.getInstance().addUser(newUser);
        resp.setContentType("text/html");
        ServletContext context = getServletContext();
        context.setAttribute("user", newUser);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/add");
        dispatcher.forward(req, resp);
    }
}
