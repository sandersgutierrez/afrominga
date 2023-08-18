package io.github.sandersgutierrez.afrominga.application.web.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

@WebServlet(name = "io.github.sandersgutierrez.afrominga.about", urlPatterns = "/about")
public class AboutServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/views/about.jsp");
        rd.forward(request, response);
    }
}
