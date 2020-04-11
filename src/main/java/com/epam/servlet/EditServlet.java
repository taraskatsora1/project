package com.epam.servlet;

import com.epam.DBConnector;
import com.epam.Plane;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int idPlanes = Integer.parseInt(request.getParameter("idPlanes"));
            int liftingWeight = Integer.parseInt(request.getParameter("liftingWeight"));
            int maxDistance = Integer.parseInt(request.getParameter("maxDistance"));
            int consumption = Integer.parseInt(request.getParameter("consumption"));
            int numberPlaces = Integer.parseInt(request.getParameter("numberPlaces"));
            Plane plane = new Plane(idPlanes, liftingWeight, maxDistance,consumption,numberPlaces);
            DBConnector.update(plane);
            response.sendRedirect(request.getContextPath() + "/MyJsp");
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int idPlanes = Integer.parseInt(request.getParameter("idPlanes"));
            Plane plane = DBConnector.selectOne(idPlanes);
            if(plane!=null) {
                request.setAttribute("plane", plane);
                getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
            }
            else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}
