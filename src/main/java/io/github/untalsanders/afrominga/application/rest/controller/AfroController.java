package io.github.untalsanders.afrominga.application.rest.controller;

import com.google.gson.Gson;
import io.github.untalsanders.afrominga.application.service.AfroServiceImpl;
import io.github.untalsanders.afrominga.domain.service.AfroService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class AfroController extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(AfroController.class);

    private final AfroService afroService;

    public AfroController() {
        this.afroService = new AfroServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String pathInfo = req.getServletPath();
        LOGGER.info("PATH: {}", pathInfo);

        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        res.setStatus(HttpServletResponse.SC_OK);
        res.getWriter().write(new Gson().toJson(afroService.getAll()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
