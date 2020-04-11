package com.epam.servlet;

import com.epam.DBConnector;
import com.epam.Plane;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/")
public class Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            ArrayList<Plane> planes = DBConnector.select();
            request.setAttribute("planes", planes);
            getServletContext().getRequestDispatcher("/MyJsp.jsp").forward(request, response);
    }
}