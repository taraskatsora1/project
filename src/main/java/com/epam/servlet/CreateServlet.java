package com.epam.servlet;

import com.epam.DBConnector;
import com.epam.Plane;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int liftingWeight = Integer.parseInt(request.getParameter("liftingWeight"));
            int maxDistance = Integer.parseInt(request.getParameter("maxDistance"));
            int consumption = Integer.parseInt(request.getParameter("consumption"));
            int numberPlaces = Integer.parseInt(request.getParameter("numberPlaces"));
            Plane plane = new Plane(liftingWeight, maxDistance, consumption, numberPlaces);
            DBConnector.insert(plane);
            response.sendRedirect(request.getContextPath() + "/MyJsp");
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
    }
}
