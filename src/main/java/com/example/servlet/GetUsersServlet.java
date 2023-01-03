package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users")
public class GetUsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        ServletContext context=getServletContext();
        context.setAttribute("users",Warehouse.getInstance().getUsers());
        resp.sendRedirect(req.getContextPath() + "/users");
    }
    //write your code here!
}
