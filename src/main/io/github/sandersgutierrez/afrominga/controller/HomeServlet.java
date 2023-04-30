package io.github.sandersgutierrez.afrominga.controller;

import java.io.IOException;
import java.io.Serial;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "home", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");

        req.setAttribute("firstname", firstName);
        req.setAttribute("lastname", lastName);

        RequestDispatcher rd = req.getRequestDispatcher("/views/home.jsp");
        rd.forward(req, res);
    }
}